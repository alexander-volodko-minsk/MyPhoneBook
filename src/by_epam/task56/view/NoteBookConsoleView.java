package by_epam.task56.view;

import java.util.ArrayList;

import by_epam.task56.entity.Note;
import by_epam.task56.entity.NoteBook;

/*
 * Класс NoteBookConsoleView, представляет собой вид нашей программы
 * содержит перегруженные методы вывода на консоль записей Note нашей записной книги NoteBook
 */

public class NoteBookConsoleView 
{
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
	
	//метод print с ArrayList
	public void print(ArrayList<Note> notesToPrint)
	{
		System.out.println("Printing some of the notes");
		
		for ( Note noteToView : notesToPrint)
		{
			System.out.println(noteToView.toString());
		}
	}

}
