package by_epam.task56.dao.impl.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



import by_epam.task56.dao.DaoException;
import by_epam.task56.dao.FindDao;
import by_epam.task56.entity.Note;

public class SqlFindDao implements FindDao

{
	
	/*
	 * Singleton
	 * _____________________________
	 */
	private static SqlFindDao instance = null;//статический экземпляр класса DaoFactory со ссылкой instance
	
	
	//Переопределяем констуктор по умолчанию
	private SqlFindDao()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static SqlFindDao getInstance()
	{
		if (instance == null) 
		{
			instance = new SqlFindDao();
		}
		return instance;
	}
	/*
     * _____________________________
	 * Singleton
	 */
	
	
	//Метод, переводящий дату из String в Date
	static Date dateFromString(String someDate) throws DaoException
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat();//заводим форматтер даты
		dateFormatter.applyPattern("dd.mm.yyyy");
		Date dateFromString;
		
		//переводим в Date данные типа Ыекштп
		try 
		{
			dateFromString = dateFormatter.parse(someDate);
		} 
		catch (ParseException e) 
		{
			throw new DaoException("DAO exception");
		}
		return dateFromString;
	}
	
	
	
    //переопределенный метод интерфейса FindDao
	@Override
	public ArrayList<Note> findByDate(String context) throws DaoException 
    {

    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для записей Note
    	Connection connect = null;//объявляем переменную соединения
    	
    	//Данные соединения с базой данных
    	String url = "jdbc:mysql://localhost:3306/";
    	String dbName = "notebook";
    	String driver = "com.mysql.jdbc.Driver";
    	String userName = "root";
    	String password = "root";
    	 
    	
    	try
    	{
    		//соединение с базой данных
    		Class.forName(driver).newInstance();
    		connect = DriverManager.getConnection(url + dbName, userName, password);
			
    		//выбираем записи с той же датой
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM notes WHERE notes.noteDate LIKE ('%' '%' ?)");
			ps.setString(1, context);
			ResultSet rs = ps.executeQuery();
			
			//чтение по строкам из базы данных
			while (rs.next()) 
			{
				String noteText = rs.getString(1);//получаем текст записи Note из первого поля 
				int noteImportance = rs.getInt(2);//получаем важность записи Note из второго поля
				String noteDateInString = rs.getString(3);//получаем дату записи Note в String  из третьего поля
				Date noteDate = SqlFindDao.dateFromString(noteDateInString);//переводим дату записи Note из String в Date
				
				//создаем экземпляр аписи Note из полученных данных из базы данных
				Note note = new Note(noteText, noteImportance, noteDate);
				
				//добавляем Note в коллекцию notes
				findedNotes.add(note);
				
			}    
			
    	}
    	
		catch (SQLException e)
		{
			throw new DaoException("DAO exception");
		}
		catch (Exception e)
		{
			throw new DaoException("DAO exception");
		}
    	
    	finally
    	{
    		try 
    		{
				connect.close();//закрываем подключение
			}
    		catch (SQLException | NullPointerException e)
    		{
				throw new DaoException("DAO exception");
			}
    	}

    	//возвращаем коллекцию записей
		return findedNotes;
    }
	

    //переопределенный метод интерфейса FindDao
	@Override
	public ArrayList<Note> findByText(String context) throws DaoException
    {

    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для записей Note
    	Connection connect = null;
    	
    	//Данные соединения с базой данных
    	String url = "jdbc:mysql://localhost:3306/";
    	String dbName = "notebook";
    	String driver = "com.mysql.jdbc.Driver";
    	String userName = "root";
    	String password = "root";
    	
    	 
    	
    	try
    	{
    		//соединение с базой данных
    		Class.forName(driver).newInstance();
    		connect = DriverManager.getConnection(url + dbName, userName, password);
			
    		//выбираем записи с тем же текстом
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM notes WHERE notes.noteText LIKE (? '%' '%')");
			ps.setString(1, context);
			ResultSet rs = ps.executeQuery();
			
			//чтение по строкам из базы данных
			while (rs.next()) 
			{
				String noteText = rs.getString(1);//получаем текст записи Note из первого поля 
				int noteImportance = rs.getInt(2);//получаем важность записи Note из второго поля
				String noteDateInString = rs.getString(3);//получаем дату записи Note в String  из третьего поля
				Date noteDate = SqlFindDao.dateFromString(noteDateInString);//переводим дату записи Note из String в Date
				
				//создаем экземпляр аписи Note из полученных данных из базы данных
				Note note = new Note(noteText, noteImportance, noteDate);
				
				//добавляем Note в коллекцию notes
				findedNotes.add(note);
				
			}    
    	}
    	
		catch (SQLException e)
		{
			throw new DaoException("DAO exception");
		}
		catch (Exception e)
		{
			throw new DaoException("DAO exception");
		}
    	
    	finally
    	{
    		try 
    		{
				connect.close();//закрываем подключение
			}
    		catch (SQLException | NullPointerException e)
    		{
				throw new DaoException("DAO exception");
			}
    	}

    	//возвращаем коллекцию записей
		return findedNotes;
    }

}


