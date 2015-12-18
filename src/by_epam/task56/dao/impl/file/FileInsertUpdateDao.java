package by_epam.task56.dao.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import by_epam.task56.dao.DaoException;
import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.entity.Note;

//Класс имплеменченный от InsertUpdateDao, наследованный от MemoryDaoFactory, работающий с памятью memory
//Реализован по принципу Singleton
public class FileInsertUpdateDao implements InsertUpdateDao
{
	/*
	 * Singleton
	 * _____________________________
	 */
	private static FileInsertUpdateDao instance = null;//статический экземпляр класса MemoryInsertUpdateDao со ссылкой instance
	
	//Переопределяем констуктор по умолчанию
	public FileInsertUpdateDao()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса MemoryInsertUpdateDao со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static FileInsertUpdateDao getInstance()
	{
		if (instance == null) 
		{
			instance = new FileInsertUpdateDao();
		}
		return instance;
	}
	/*
     * _____________________________
	 * Singleton
	 */
	
	
	
	@Override
	//переопределенный от интерфейса InsertUpdateDao метод addNewNote, работающий с памятью memory
	public ArrayList<Note> addNewNote(String context) throws DaoException
	{

		ArrayList<Note> notesFromFile = new ArrayList<Note>();
		PrintWriter printWriter = null;//объявляем переменную потока
		
        //записываем полученный экземпляр записной книги в файл
        try 
        {
        	notesFromFile = FileInsertUpdateDao.readFromFile("notebook.txt");//получаем ArrayList <Notes> из файла
            Note note = new Note(context);//создаем запись для добавления по context из Request
            
            
            notesFromFile.add(note);//добавляем запись в записную книгу
            
			FileWriter outPutSteam = new FileWriter("notebook.txt");//создаем потоковый объект
	        BufferedWriter bufferedWriter = new BufferedWriter(outPutSteam);//буферизованный оток ввода
	        printWriter = new PrintWriter(bufferedWriter); //усовершенствованная работа с символами UNICODE
	        
	        
	        //построчная запись в файл
	        for(Note someNote : notesFromFile)
	        {
	        	printWriter.println(someNote);//запись одного Note 
	        }
   
		}
        
        catch (IOException e) 
        {
        	throw new DaoException("DAO exception");
		}
        
        finally
        {
        	try 
        	{
        		printWriter.close();//закрываем наиболее вложенный поток
        	}
        	catch (NullPointerException e) 
        	{
        		throw new DaoException("DAO exception");
			} 
        	
        }
        return notesFromFile;
	}
	
	/*
	 * Вспомогательные методы
	 */
    //Метод разбивающий строку на требуемые данные по определенному правилу
	private static Note dataFromLine(String lineToParse) throws ParseException
    {
    	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
    	
    	Note noteFromReadedLine = new Note();//заводим пустой экземпляр записи Note
    	String [] dataFromStringLine;//заводим массив String для частей строки
    	dataFromStringLine = lineToParse.split("\t");//разбиваем строку по существующему правилу
    	
    	//Добавляем в нашу пустую запись Note конкретные данные
    	
    	noteFromReadedLine.setNoteText(dataFromStringLine[0]);//текст записи из строки
    	noteFromReadedLine.setNoteImportance(Integer.parseInt(dataFromStringLine[1]));//важность записи из строки
    	Date dateFromStringLine = dateFormatter.parse(dataFromStringLine[2]);//переводим дату записи в формате String из строки в формат Date
    	noteFromReadedLine.setNoteDate(dateFromStringLine);//дата из строки

		return noteFromReadedLine;//возвращаем заполненный данными экземпляр класса Note
    	
    }
	
	
    //метод, читающий по произвольному правилу данные из файла
	private static ArrayList<Note> readFromFile(String pathToReadFile) throws DaoException
    {
    	ArrayList<Note> notesFromFile = new ArrayList<Note>();//заводим ArrayList для найденных записей
    	BufferedReader bufferedReader = null;//объявляем переменную потока
    	
        try
        {
        	FileReader inputSteam = new FileReader(pathToReadFile);//создаем потоковый объект
			bufferedReader = new BufferedReader(inputSteam);////буферизованный поток чтения
        	
            //построчное чтение из файла
        	String line;
            while ((line = bufferedReader.readLine()) != null)
            {
 	           Note singleNoteFromFile = FileInsertUpdateDao.dataFromLine(line);//создаем экземпляр записи Note на основании прочитанных данных из строки
 	           notesFromFile.add(singleNoteFromFile);  //добавляем в коллекцию записей конкретную запись 
            }
        }
        catch (IOException | ParseException e) 
        {
        	throw new DaoException("DAO exception");
		}
        
        finally
        {
        	try 
        	{
				bufferedReader.close();//закрываем наиболее вложенный поток
			} 
        	catch (IOException | NullPointerException e) 
        	{
        		throw new DaoException("DAO exception");
			} 
        }
        
		return notesFromFile;
    }
	/*
	 * Вспомогательные методы
	 */

}
