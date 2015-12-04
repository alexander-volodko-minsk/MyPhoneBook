package by_epam.task2.dao.memory;

import by_epam.task2.entity.Note;
import by_epam.task2.entity.NoteBook;
import by_epam.task2.view.NoteBookConsoleView;

public class Runner
{

	public static void main(String[] args)
	{
		NoteBook testNoteBook = NoteBookProvider.getInstance().getNotebook();//������� �������� NoteBook
		Note testNote = new Note("testMessage");//������� �������� ������ Note
		testNoteBook.getNotes().add(testNote);//��������� ������ � �����
		NoteBookConsoleView testNoteBookConsoleView = new NoteBookConsoleView(testNoteBook);//������� �������� NoteBookConsoleView
		testNoteBookConsoleView.print();//������ ������� ��������� � ������ ���� ������� �� ����� � �������� ������
		NoteBookProvider.getInstance();//��������� ������������ Singleton, ������ ������� ��������� �� ������
	}

}
