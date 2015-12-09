package by_epam.task4.classesForDaoPattern;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import by_epam.task3.dao.NoteBookProvider;
import by_epam.task3.entity.Note;
import by_epam.task3.entity.NoteBook;

public class MemoryFindDao implements FindDao
{
	/*
	 * Singleton
	 * _____________________________
	 */
	private static MemoryFindDao instance = null;//статический экземпляр класса MemoryFindDao со ссылкой instance
	
	//Переопределяем констуктор по умолчанию
	private MemoryFindDao()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static MemoryFindDao getInstance()
	{
		if (instance == null) 
		{
			instance = new MemoryFindDao();
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
	
	
	
	public ArrayList<Note> findByDate(String context)
	{
		ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToFind = noteBook.getNotes();//получаем ArrayList <Notes>
        
        
        //ищем по всем записям notesToFind требуемую дату
        for(Note someNote : notesToFind)
        {
        	Date dateOfNoteInDate = someNote.getNoteDate();//получаем Date записи
        	
        	//формируем из аттрибутов Date строку для сравнения со строкой Request
        	String dateOfNoteInString = MemoryFindDao.dateInString(dateOfNoteInDate);

        	//добавляем в коллекцию подходящие записи
        	if(context.equals(dateOfNoteInString))
        	{
        		findedNotes.add(someNote);
        	}
        }
		return findedNotes;
		
	}
	
	
	
	//переопределенный метод интерфейса FindDao
	@Override
	public ArrayList<Note> findByText(String context)
	{
		ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToFind = noteBook.getNotes();//получаем ArrayList <Notes>
        
        //ищем по всем записям notesToFind требуемую строку
        for(Note someNote : notesToFind)
        {
        	if(context.equals(someNote.getNoteText()))
        	{
        		findedNotes.add(someNote);
        	}
        }
		return findedNotes;	
	}
	

}
