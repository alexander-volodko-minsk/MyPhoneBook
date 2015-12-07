package by_epam.task3.entity;

import java.util.Date;


/*
 * Класс Note, представляющий собой отдельную запись.
 * В качестве полей класса используются:
 * noteText, noteImportance, noteDate
 */


public class Note 
{
	
	/*
	 * Поля класса
	 * ___________
	 */
	private String noteText;//текст записи
	private int noteImportance;//важность записи
	private Date noteDate;//дата записи
	/*
	 *___________
	 * Поля класса
	 */
	
	
	
	/*
	 * Сеттеры и геттеры полей класса
	 * ______________________________
	 */
	//getNoteText
	public String getNoteText ()
	{
		return noteText;
	}
	//setNoteText
	public void setNoteText (String noteText)
	{
		this.noteText=noteText;
	}
	
	
	//getNoteImportance
	public int getNoteImportance ()
	{
		return noteImportance;
	}
	//setNoteImportance
	public void setNoteImportance (int noteImportance)
	{
		this.noteImportance=noteImportance;
	}
	
	
	//getNoteDate
	public Date getNoteDate ()
	{
		return noteDate;
	}	
	//setNoteDate
	public void setNoteDate (Date noteDate)
	{
		this.noteDate=noteDate;
	}
	/*
	 * ______________________________
	 * Сеттеры и геттеры полей класса
	 */

	
	
	/*
	 * Конструкторы класса
	 * ___________________
	 */
	//создание записи с указанием только текста записи
	public Note (String noteText)
	{
		this.noteText=noteText;
		this.noteDate=new Date();//дата выставляется согласно текущей дате
		this.noteImportance=0;//значение важности записи по умолчанию равно "0"
	}
	
	//создание записи с указанием текста записи и ее важности
	public Note (String noteText, int noteImportance)
	{
		this.noteText=noteText;//текст записи передается в качестве параметра конструктора
		this.noteDate=new Date();//дата выставляется согласно текущей дате
		this.noteImportance=noteImportance;//важность записи передается в качестве параметра конструктора
	}
	/*
	 * ___________________
	 * Конструкторы класса
	 */
	
	


	/*
	 * Переопределяем метод toString для класса Note
	 * предназначен для того чтобы предоставить ПОЛНУЮ инфу об объекте, должен учесть все
	 * __________________________________________________________________________________
	 */
	@Override
	public String toString()
	{
		StringBuilder build = new StringBuilder();//создаем строку, которая будет содержать всю информацию
		
		build.append("class=");
		build.append(this.getClass().getName());//получаем имя класса
		
		build.append(";noteText=");
		build.append(this.noteText);//получаем текст записи
		
		build.append(";noteImportance=");
		build.append(this.noteImportance);//получаем важность записи
		
		build.append(";noteDate=");
		build.append(this.noteDate);//получаем дату записи

		return build.toString();//возвращаем скомпанованную строку
	}
	/*
	 * Переопределяем метод toString для класса Note
	 * __________________________________________________________________________________
	 */

	
	
	
	
	/*
	 * Переопределяем метод hashCode для класса Note
	 * _____________________________________________
	 */
	@Override
	public int hashCode() 
	{
		/*
		 * суммируем хэшкоды каждого поля класса умноженные на простое число
		 * (примитивные данные не имеют хэшкода, поэтому используем их значение напрямую)
		 */

		return 9*noteText.hashCode()+7*noteImportance+23*noteDate.hashCode();
	}
	/*
	 * _____________________________________________
	 * Переопределяем метод hashCode для класса Note
	 */

	
	
	/*
	 * Переопределяем метод equals для класса Note
	 * ___________________________________________
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
		if (getClass() != obj.getClass())
		{
			return false;
		}	
		
		
		/*
		 * //создаем объект Note со ссылкой other, приводим к нашему классу, чтобы сравнить поля
		 */
		Note other = (Note) obj;
		
		/*
		 * сравнение полей объектов
		 * (полей noteDate, noteText, noteImportance)
		 */
		//noteDate
		if (noteDate == null)
		{
			if (other.noteDate != null)
			{
				return false;
			}		
		} 
		else if (!noteDate.equals(other.noteDate))
		{
			return false;
		}
		
		//noteImportance
		if (noteImportance != other.noteImportance)
		{
			return false;
		}	
		
		//noteText
		if (noteText == null)
		{
			if (other.noteText != null)
			{
				return false;
			}	
		} 
		else if (!noteText.equals(other.noteText))
		{
			return false;
		}	
		return true;
	}	
	/*
	 * ___________________________________________
	 * Переопределяем метод equals для класса Note
	 */

}
