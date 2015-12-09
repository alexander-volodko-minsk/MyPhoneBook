package by_epam.task04.dao;

import by_epam.task04.entity.NoteBook;

/*
 * Класс NoteBookProvider реализован по принципу Singleton
 * Мы выбрали способ, когда NoteBookProvider создастся, когда вызовется метод get Instance
 */

public class NoteBookProvider 
{
	private static NoteBookProvider instance = null;//статический экземпляр класса NoteBookProvider со ссылкой instance
	private NoteBook noteBookToProvide ;//экземпляр класса NoteBook со ссылкой noteBookToProvide для провайдера instance
	
	
	//Переопределяем констуктор по умолчанию
	private NoteBookProvider()
	{
		noteBookToProvide = new NoteBook();
	}
	
	
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static NoteBookProvider getInstance()
	{
		if (instance == null) 
		{
			instance = new NoteBookProvider();
		}
		return instance;
	}
	

	//Геттер класса. возвращающий записную книгу
	public NoteBook getNoteBook() 
	{
		return noteBookToProvide;
	}

	
}

/*
 * Cуществует второй способ Singleton
 * NoteBookProvider создастся при загрузке класса в память(инициализация статических полей)
 */

/*
public class NoteBookProvider extends NoteBook 
{
	private static final NoteBook instance = new NoteBookProvider();
	
	private NoteBookProvider()
	{
		NoteBook noteBook = new NoteBook();
	}
	
	public static NoteBook getInstance()
	{
		if (instance == null) 
		{
			instance = new NoteBook();
			System.out.println("created");
		}
		else
		{
			System.out.println("!cannot created!-was created before");
		}
		return instance;
	}
	
	public NoteBook getNoteBook()
	{
		return noteBook();
	}
}
*/


