package by_epam.task56.dao.impl.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import by_epam.task56.dao.DaoException;
import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.entity.Note;

public class SqlInsertUpdateDao implements InsertUpdateDao 

{
	
	/*
	 * Singleton
	 * _____________________________
	 */
	private static SqlInsertUpdateDao instance = null;//статический экземпляр класса DaoFactory со ссылкой instance
	
	
	//Переопределяем констуктор по умолчанию
	private SqlInsertUpdateDao()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static SqlInsertUpdateDao getInstance()
	{
		if (instance == null) 
		{
			instance = new SqlInsertUpdateDao();
		}
		return instance;
	}
	/*
     * _____________________________
	 * Singleton
	 */
	
 
	
	//Метод, переводящий дату из Date в String
	static String dateInString(Date someDate)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
		String dateInString = dateFormatter.format(someDate);//переводим в String требуемого формата данные типа Date
		return dateInString;
	}
	
	
	
    
	@Override
	//переопределенный от интерфейса InsertUpdateDao метод addNewNote, работающий с базой данных
	public ArrayList<Note> addNewNote(String context) throws DaoException
	{
		
        Note note = new Note(context);//создаем запись для добавления по context из Request
        ArrayList<Note> notesToAdd = new ArrayList<Note>();//создаем коллекцию 
        Connection connect = null;//объявляем переменную соединения
        
		//Данные соединения с базой данных
    	String url = "jdbc:mysql://localhost:3306/";
    	String dbName = "notebook";
    	String driver = "com.mysql.jdbc.Driver";
    	String userName = "root";
    	String password = "root";
    	
    	try
    	{
            SqlInsertUpdateDao.getInstance();
    		notesToAdd = SqlInsertUpdateDao.readFromDataBase();//получаем ArrayList <Notes>
    		//соединение с базой данных
    		Class.forName(driver).newInstance();
    		connect = DriverManager.getConnection(url + dbName, userName, password);
			
			PreparedStatement ps = connect.prepareStatement("INSERT INTO notes(noteText, noteImportance, noteDate) VALUES(?,?,?)");
			
			ps.setString(1, note.getNoteText());
			ps.setInt(2, note.getNoteImportance());
			
			String noteInString = SqlInsertUpdateDao.dateInString(note.getNoteDate());
			ps.setString(3, noteInString);
			
			
			ps.executeUpdate();
			
    	}
    	
		catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e)
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
        notesToAdd.add(note);//добавляем запись в ArrayList экземпляра NoteBook
    	return notesToAdd;	
	}
	
    
    
    //метод, читающий все данные из базы данных и возвращающий ArrayList<Note>
    public static ArrayList<Note> readFromDataBase() throws DaoException
    {

    	ArrayList<Note> notesFromDataBase = new ArrayList<Note>();//заводим ArrayList для записей Note
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
			
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notes");
			
			//чтение по строкам из базы данных
			while (rs.next()) 
			{
				String noteText = rs.getString(1);//получаем текст записи Note из первого поля 
				int noteImportance = rs.getInt(2);//получаем важность записи Note из второго поля
				String noteDateInString = rs.getString(3);//получаем дату записи Note в String  из третьего поля
				Date noteDate = SqlFindDao.dateFromString(noteDateInString);//переводим дату записи Note из String в Date
				
				//создаем экземпляр аписи Note из полученных данных из базы данных
				Note noteFromDataBase = new Note(noteText, noteImportance, noteDate);
				
				//добавляем Note в коллекцию notes
				notesFromDataBase.add(noteFromDataBase);
				
			}    

    	}
    	
		catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e)
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
		return notesFromDataBase;
    }

}
