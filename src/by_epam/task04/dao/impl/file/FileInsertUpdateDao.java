package by_epam.task04.dao.impl.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import by_epam.task04.dao.InsertUpdateDao;
import by_epam.task04.entity.Note;

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
	
	
	//Метод, переводящий дату из Date в String
	static public String dateInString(Date someDate)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
		String dateInString = dateFormatter.format(someDate);//переводим в String требуемого формата данные типа Date
		return dateInString;
	}
	
	
	@Override
	//переопределенный от интерфейса InsertUpdateDao метод addNewNote, работающий с памятью memory
	public ArrayList<Note> addNewNote(String context)
	{
        ArrayList<Note> notesFromFile = FileFindDao.readFromFile("notebook.txt");//получаем ArrayList <Notes> из файла
        
        //записываем полученный экземпляр записной книги в файл
        try 
        {
            Note note = new Note(context);//создаем запись для добавления по context из Request
            
            
            notesFromFile.add(note);//добавляем запись в записную книгу
            
			FileWriter outPutSteam = new FileWriter("notebook.txt");//создаем потоковый объект
	        BufferedWriter bufferedWriter = new BufferedWriter(outPutSteam);//буферизованный оток ввода
	        PrintWriter printWriter = new PrintWriter(bufferedWriter); //усовершенствованная работа с символами UNICODE
	        
	        
	        //построчная запись в файл
	        for(Note someNote : notesFromFile)
	        {
	        	printWriter.println(someNote);//запись одного Note 
	        }

	        printWriter.close();//закрываем наиболее вложенный поток
		}
        
        catch (IOException e) 
        {
			System.out.println(e.getMessage());
		}
        return notesFromFile;
	}

}
