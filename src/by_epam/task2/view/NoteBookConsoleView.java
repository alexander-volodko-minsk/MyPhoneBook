package by_epam.task2.view;

import by_epam.task2.entity.Note;
import by_epam.task2.entity.NoteBook;

/*
 * Класс NoteBookConsoleView, представляет собой вид нашей программы
 * содержит перегруженные методы вывода на консоль записей Note нашей записной книги NoteBook
 */

public class NoteBookConsoleView 
{
	/*
	//Поле класса
	private NoteBook noteBookToView;
	
    //Коструктор класса, в качестве параметра передается наша записная книга
	public NoteBookConsoleView(NoteBook noteBookToView)
	{
		this.noteBookToView=noteBookToView;
	}
	*/
	
	
	/*
	 * Перегружаем методы print
	 * Метод print способен выводить как все записи, так и несколько указанных записей
	 */
	//метод print выводящий все записи
	public void print(NoteBook noteBookToView)
	{
		System.out.println("Printing all of the notes");
		
		for ( Note noteToView : noteBookToView.getNotes())
		{
			System.out.println(noteToView.toString());
		}
	}
	//метод print с переменным числом параметров
	public void print(Note ... args)
	{
		System.out.println("Printing some of the notes");
		
		for ( Note noteToView : args)
		{
			System.out.println(noteToView.toString());
		}
	}

}
