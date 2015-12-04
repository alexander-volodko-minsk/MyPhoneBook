package by_epam.task2.view;

import by_epam.task2.entity.Note;
import by_epam.task2.entity.NoteBook;

/*
 * ����� NoteBookConsoleView, ������������ ����� ��� ����� ���������
 * �������� ������������� ������ ������ �� ������� ������� Note ����� �������� ����� NoteBook
 */

public class NoteBookConsoleView 
{
	//���� ������
	private NoteBook noteBookToView;
	
    //���������� ������, � �������� ��������� ���������� ���� �������� �����
	public NoteBookConsoleView(NoteBook noteBookToView)
	{
		this.noteBookToView=noteBookToView;
	}
	
	
	/*
	 * ����������� ������ print
	 * ����� print �������� �������� ��� ��� ������, ��� � ��������� ��������� �������
	 */
	//����� print ��������� ��� ������
	public void print()
	{
		System.out.println("Printing all of the notes");
		
		for ( Note noteToView : noteBookToView.getNotes())
		{
			System.out.println(noteToView.toString());
		}
	}
	//����� print � ���������� ������ ����������
	public void print(Note ... args)
	{
		System.out.println("Printing some of the notes");
		
		for ( Note noteToView : args)
		{
			System.out.println(noteToView.toString());
		}
	}

}
