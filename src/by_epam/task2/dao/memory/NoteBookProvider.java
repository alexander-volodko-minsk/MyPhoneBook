package by_epam.task2.dao.memory;

import by_epam.task2.entity.NoteBook;

/*
 * ����� NoteBookProvider ���������� �� �������� Singleton
 * �� ������� ������, ����� NoteBookProvider ���������, ����� ��������� ����� get Instance
 */

public class NoteBookProvider 
{
	private static NoteBookProvider instance = null;//����������� ��������� ������ NoteBookProvider �� ������� instance
	private NoteBook noteBookToProvide = null;//��������� ������ NoteBook �� ������� noteBookToProvide ��� ���������� instance
	
	
	//�������������� ���������� �� ���������
	private NoteBookProvider()
	{
		noteBookToProvide = new NoteBook();
	}
	
	
	
	/*
	 * ����������� �����, ��������� ��������� ������ NoteBookProvider �� ������� instance
	 * ��� ������������ ��� ��������� instance
	 */
	public static NoteBookProvider getInstance()
	{
		if (instance == null) 
		{
			instance = new NoteBookProvider();
			System.out.println("created");
		}
		else
		{
			System.out.println("!cannot created!-was created before");
		}
		return instance;
	}
	

	//������ ������. ������������ �������� �����
	public NoteBook getNotebook() 
	{
		return noteBookToProvide;
	}

	
}

/*
 * C��������� ������ ������ Singleton
 * NoteBookProvider ��������� ��� �������� ������ � ������(������������� ����������� �����)
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


