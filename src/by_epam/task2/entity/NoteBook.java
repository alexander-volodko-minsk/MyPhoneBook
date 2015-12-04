package by_epam.task2.entity;

import java.util.ArrayList;

/*
 * ����� NoteBook, �������������� ����� ��������� �������.
 * � �������� ���� ������ ������������ ArrayList ������� ������ Note
 */

public class NoteBook 
{
	
	//���� ������ 
	private ArrayList<Note> notes = new ArrayList<Note>() ;
	
	
	
	
	//������ ������
	public ArrayList<Note> getNotes ()
	{
		return notes;
	}
	
	
	
    /*
     * �������������� ����������� ������ �� ���������
     * ������ ������� ����� �����������, ����� ��������� ������ NoteBookProvider
     */
	public NoteBook()
	{
		this.notes=new ArrayList<Note>() ;
	}
	

	
	
	/*
	 * �������������� ����� toString ��� ������ NoteBook
	 * ������������ ��� ���� ����� ������������ ������ ���� �� �������, ������ ������ ���
	 * __________________________________________________________________________________
	 */
	@Override
	public String toString()
	{
		
		StringBuilder build = new StringBuilder();//������� ������, ������� ����� ��������� ��� ����������
		
		build.append("class=");
		build.append(this.getClass().getName());//�������� ��� ������
		
		build.append(";quantity of notes=");
		build.append(this.notes.size());//�������� ���������� �������
		
		return 	build.toString();//���������� �������������� ������
	}	
	/*
	 * __________________________________________________________________________________
	 * �������������� ����� toString ��� ������ NoteBook
	 */

	
	
	/*
	 * �������������� ����� hashCode ��� ������ NoteBook
	 * _________________________________________________
	 */
	@Override
	public int hashCode()
	{
		/*
		 * ��������� ������� ������� ���� ������ ���������� �� ������� �����
		 * (����������� ������ �� ����� �������, ������� ���������� �� �������� ��������)
		 */
		
		return 23*notes.hashCode();
	}
	/*
	 * _________________________________________________
	 * �������������� ����� hashCode ��� ������ NoteBook
	 */

	
	
	
	/*
	 * �������������� ����� equals ��� ������ NoteBook
	 * _______________________________________________
	 */
	@Override
	public boolean equals(Object obj)
	/*
	 *�������� ����������� Object, ��� ��� � ������� Object ���������� Object, 
	 *� ��� ���� ��������������, ������ ��������� ����� ��������
	 */
	{
		//��������� �� ������ (this � ������ ������ ������������ ����� Object obj)
		if (this == obj)
		{
			return true;
		}
		
		//null ��������, ��� ������ �� ��������� �� �� ����� ������
		if (obj == null)
		{
			return false;
		}
		
		
		/*
		 * ���������� ������ ��������,
		 * ��� ��� ��������� � ��������� ������ �������� ����� ���� ���������
		 */
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		
		/*
		 * //������� ������ Note �� ������� other, �������� � ������ ������, ����� �������� ����
		 */
		NoteBook other = (NoteBook) obj;
		
		/*
		 * ��������� ����� ��������
		 * (����� noteDate, noteText, noteImportance)
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
	 * �������������� ����� equals ��� ������ NoteBook
	 */


}
