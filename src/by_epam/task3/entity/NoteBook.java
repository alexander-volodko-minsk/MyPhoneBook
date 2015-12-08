package by_epam.task3.entity;

import java.util.ArrayList;

/*
 * Класс NoteBook, представляющий собой коллекцию записей.
 * В качестве поля класса используется ArrayList записей класса Note
 */

public class NoteBook 
{
	
	//Поле класса 
	private ArrayList<Note> notes = new ArrayList<Note>() ;
	
	
	
	
    /*
     * переопределяем конструктор класса по умолчанию
     * Объект ноутбук будет создаваться, когда создастся объект NoteBookProvider
     */
	public NoteBook()
	{
		this.notes=new ArrayList<Note>() ;
	}
	
	
	
	
	//Геттер класса
	public ArrayList<Note> getNotes ()
	{
		return notes;
	}
	
	

	
	/*
	 * Переопределяем метод toString для класса NoteBook
	 * предназначен для того чтобы предоставить ПОЛНУЮ инфу об объекте, должен учесть все
	 * __________________________________________________________________________________
	 */
	@Override
	public String toString()
	{
		
		StringBuilder build = new StringBuilder();//создаем строку, которая будет содержать всю информацию
		
		build.append("Class : ");
		build.append(this.getClass().getName()+" ; ");//получаем имя класса
		
		build.append("Quantity of notes : ");
		build.append(this.notes.size()+"\n");//получаем количество записей
		
		//build.append(notes.toString());//получаем все записи 
		
		return 	build.toString();//возвращаем скомпанованную строку
	}	
	/*
	 * __________________________________________________________________________________
	 * Переопределяем метод toString для класса NoteBook
	 */

	
	
	/*
	 * Переопределяем метод hashCode для класса NoteBook
	 * _________________________________________________
	 */
	@Override
	public int hashCode()
	{
		/*
		 * суммируем хэшкоды каждого поля класса умноженные на простое число
		 * (примитивные данные не имеют хэшкода, поэтому используем их значение напрямую)
		 */
		
		return 23*notes.hashCode();
	}
	/*
	 * _________________________________________________
	 * Переопределяем метод hashCode для класса NoteBook
	 */

	
	
	
	/*
	 * Переопределяем метод equals для класса NoteBook
	 * _______________________________________________
	 */
	@Override
	public boolean equals(Object obj)
	/*
	 *передаем обязательно Object, так как в объекте Object передается Object, 
	 *а нам надо переопределить, значит сигнатуру нужно оставить
	 */
	{
		//сравнение по ссылке (this в данном случае представляет собой Object obj)
		if (this == obj)
		{
			return true;
		}
		
		//null означает, что ссылка не указывает ни на какой объект
		if (obj == null)
		{
			return false;
		}
		
		
		/*
		 * сравниваем классы объектов,
		 * так как сигнатура у абсолютно разных объектов может быть одинакова
		 */
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		
		/*
		 * //создаем объект Note со ссылкой other, приводим к нашему классу, чтобы сравнить поля
		 */
		NoteBook other = (NoteBook) obj;
		
		/*
		 * сравнение полей объектов
		 * (полей noteDate, noteText, noteImportance)
		 */
		//notes
		if (notes == null) 
		{
			if (other.notes != null)
			{
				return false;
			}
		}
		else if (!notes.equals(other.notes))
		{
			return false;
		}
		return true;
	}
	/*
	 *_______________________________________________
	 * Переопределяем метод equals для класса NoteBook
	 */
	
}
