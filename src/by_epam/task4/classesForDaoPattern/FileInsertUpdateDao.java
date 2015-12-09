package by_epam.task4.classesForDaoPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import by_epam.task3.dao.NoteBookProvider;
import by_epam.task3.entity.Note;
import by_epam.task3.entity.NoteBook;

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
	FileInsertUpdateDao()
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
	public ArrayList<Note> addNewNote(String context)
	{
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToAdd = noteBook.getNotes();//получаем ArrayList <Notes>
        
        //записываем полученный экземпляр записной книги в файл
        try 
        {
            Note note = new Note(context);//создаем запись для добавления по context из Request
            
            notesToAdd = noteBook.getNotes();
            
            notesToAdd.add(note);//добавляем запись в записную книгу
            
			FileWriter outPutSteam = new FileWriter("notebook.txt");//создаем потоковый объект
	        BufferedWriter bufferedWriter = new BufferedWriter(outPutSteam);//буферизованный оток ввода
	        PrintWriter printWriter = new PrintWriter(bufferedWriter); //усовершенствованная работа с символами UNICODE
	        
	        
	        //построчная запись в файл
	        for(Note someNote : noteBook.getNotes())
	        {
	        	printWriter.println(someNote);//запись одного Note 
	        }

	        printWriter.close();//закрываем наиболее вложенный поток
		}
        
        catch (IOException e) 
        {
			System.out.println(e.getMessage());
		}
        return notesToAdd;
	}

}
