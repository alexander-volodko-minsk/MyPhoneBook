package by_epam.task56.dao.impl.memory;

import java.util.ArrayList;

import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.dao.NoteBookProvider;
import by_epam.task56.entity.Note;
import by_epam.task56.entity.NoteBook;

//Класс имплеменченный от InsertUpdateDao, наследованный от MemoryDaoFactory, работающий с памятью memory
//Реализован по принципу Singleton
public class MemoryInsertUpdateDao implements InsertUpdateDao 
{
	
	/*
	 * Singleton
	 * _____________________________
	 */
	private static MemoryInsertUpdateDao instance = null;//статический экземпляр класса MemoryInsertUpdateDao со ссылкой instance
	
	//Переопределяем констуктор по умолчанию
	public MemoryInsertUpdateDao()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса MemoryInsertUpdateDao со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static MemoryInsertUpdateDao getInstance()
	{
		if (instance == null) 
		{
			instance = new MemoryInsertUpdateDao();
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
		
        Note note = new Note(context);//создаем запись для добавления по context из Request
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToAdd = noteBook.getNotes();//получаем ArrayList <Notes>
        notesToAdd.add(note);//добавляем запись в ArrayList экземпляра NoteBook
        
		return notesToAdd;
		
	}

}
