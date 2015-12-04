package com_epam.task3.classesForCommands;

import by_epam.task2.dao.memory.NoteBookProvider;
import by_epam.task2.entity.Note;
import by_epam.task2.entity.NoteBook;
import by_epam.task2.view.NoteBookConsoleView;

public class Runner3 
{

	public static void main(String[] args) 
	{
		Controller controller = new Controller();

        Request request1 = new Request("ADD_NEW_NOTE","testMessageTask3 1");
        Response response1 = controller.doAction(request1);
        NoteBookConsoleView testNoteBookConsoleView = new NoteBookConsoleView();
        testNoteBookConsoleView.print(response1.getNoteBookInResponse());
        
        
        Request request2 = new Request("ADD_NEW_NOTE","testMessageTask3 2");
        Response response2 = controller.doAction(request2);
        testNoteBookConsoleView.print(response2.getNoteBookInResponse());
        
        Request request3 = new Request("ADD_NEW_NOTE","testMessageTask3 3");
        Response response3 = controller.doAction(request3);
        testNoteBookConsoleView.print(response3.getNoteBookInResponse());
        
        Request request4 = new Request("ADD_NEW_NOTE","testMessageTask3 4");
        Response response4 = controller.doAction(request4);
        testNoteBookConsoleView.print(response4.getNoteBookInResponse());
        // set parameters

        /*
        NoteBookConsoleView testNoteBookConsoleView = new NoteBookConsoleView(response1.getNoteBookInResponse());//создаем тестовый NoteBookConsoleView
		testNoteBookConsoleView.print();//должны увидеть сообщение о выводе всех записей на экран и тестовую запись
        */
        // show response
        /*
		NoteBook testNoteBook = NoteBookProvider.getInstance().getNoteBook();//создаем тестовый NoteBook
		Note testNote = new Note("testMessage");//создаем тестовую запись Note
		testNoteBook.getNotes().add(testNote);//добавляем запись в книгу
		NoteBookConsoleView testNoteBookConsoleView = new NoteBookConsoleView(testNoteBook);//создаем тестовый NoteBookConsoleView
		testNoteBookConsoleView.print();//должны увидеть сообщение о выводе всех записей на экран и тестовую запись
		NoteBookProvider.getInstance();//проверяем правильность Singleton, должны увидеть сообщение об ошибке
        */

	}

}
