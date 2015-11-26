package by_myNoteBook;

import java.util.ArrayList;

public class NoteBook 
{
	private ArrayList<Note> Notes = new ArrayList<Note>() ;
	

    //���������� ������
	public NoteBook()
	{
		this.Notes=new ArrayList<Note>() ;
	}

	
    //���������� ������, ���������� ArrayList
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
		result = prime * result + ((Notes == null) ? 0 : Notes.hashCode());//���� true, �� +0, ���� false, �� +Notes.hashCode()
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)//��������� �� ������
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//�� �������������� � �������
			return false;
		NoteBook other = (NoteBook) obj;//������� ������
		//��������� ������� ��������
		if (Notes == null) //���� ������ �������
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
