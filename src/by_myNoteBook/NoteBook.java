package by_myNoteBook;

import java.util.ArrayList;

public class NoteBook 
{
	private ArrayList<Note> Notes = new ArrayList<Note>() ;
	

    //Коструктор класса
	public NoteBook()
	{
		this.Notes=new ArrayList<Note>() ;
	}

	
    //Коструктор класса, передающий ArrayList
	public NoteBook(ArrayList<Note> Notes)
	{
		this.Notes=Notes;
	}
	
	public ArrayList<Note> getNotes ()
	{
		return Notes;
	}
	

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Notes == null) ? 0 : Notes.hashCode());//если true, то +0, если false, то +Notes.hashCode()
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)//сравнение по ссылке
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//по принадлежности к классам
			return false;
		NoteBook other = (NoteBook) obj;//создает объект
		//сравнение нулевых объектов
		if (Notes == null) //если объект нулевой
		{
			if (other.Notes != null)
				return false;
		}
		else if (!Notes.equals(other.Notes))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "NoteBook [Notes=" + Notes + "]";
	}
	
	


	
	
}
