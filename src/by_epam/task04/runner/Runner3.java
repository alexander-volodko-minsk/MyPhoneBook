package by_epam.task04.runner;

import by_epam.task04.bean.to.Request;
import by_epam.task04.bean.to.Response;
import by_epam.task04.controller.Controller;
import by_epam.task04.view.NoteBookConsoleView;

public class Runner3 
{

	public static void main(String[] args) 
	{
		/*
		 * Создаем экземпляр класса Controller.
		 * 
		 * Controller создает final static ServiceHelper helper:
		 *     helper имеет в качестве своего поля HashMap<CommandName, InterfaceCommand> commands, в которой хранятся в 
		 *     качестве ключей - имена комманд из enum CommandName, а в качестве значений реализации InterfaceCommand.
		 *     
		 *     А так же метод InterfaceCommand getCommand(String commandName), возвращающий экземпляр класса требуемой команды
		 *     из HashMap commands.
		 */
		Controller controller = new Controller();

		/*
		 * Формируем request
		 * Поля класса Request : String commandName, requestContext
		 */
        Request request1 = new Request("ADD_NEW_NOTE","123123");
        Request request2 = new Request("ADD_NEW_NOTE","MUST NOT FIND BY TEXT");
        Request request3 = new Request("ADD_NEW_NOTE","sda");
        Request request4 = new Request("ADD_NEW_NOTE","SOME NOTE asdsasdasd");
        Request request5 = new Request("ADD_NEW_NOTE","SOME NOTE dsdasdasd");
        Request request6 = new Request("ADD_NEW_NOTE","SOME NOTE pppqwe122ppqwe");
        
        /*
         * Формируем response
         * Поля класса Request : Note noteInResponse, ArrayList<Note> notesListInResponse, NoteBook noteBookInResponse
         * 
         * Controller controller содержит метод doAction, который получает Request и возвращает Response
         */
        Response response1 = controller.doAction(request1);
        Response response2 = controller.doAction(request2);
        Response response3 = controller.doAction(request3);
        Response response4 = controller.doAction(request4);
        Response response5 = controller.doAction(request5);
        Response response6 = controller.doAction(request6);
        

        System.out.println(response6.getNotesInResponse());
        
        /*
         * Создаем экземпляр класса NoteBookConsoleView, содержащего перегруженные в зависимости от передеваемых 
         * данных(NoteBook/Note ... args) методы вывода на экран
         */
        //NoteBookConsoleView testNoteBookConsoleView = new NoteBookConsoleView();
        
        /*
         * Выводим на экран требуемые данные
         */
       // testNoteBookConsoleView.print(response1.getNoteBookInResponse());
        
        
        //Повторяем действия, проверяем не создастся ли новый экземпляр NoteBook(проверяем Singleton)
//        Request request2 = new Request("ADD_NEW_NOTE","MUST FIND");
//        Response response2 = controller.doAction(request2);
//        testNoteBookConsoleView.print(response2.getNoteBookInResponse());
//        
        //Проверяем поиск по тексту записи
        Request request7 = new Request("FIND_NOTE_TEXT","123123");
        Response response7 = controller.doAction(request7);
        System.out.println(response7.getNotesInResponse());
        //testNoteBookConsoleView.print(response3.getNotesInResponse());
       
        //Проверяем поиск по дате записи
        Request request8 = new Request("FIND_NOTE_DATE","09.12.2015");
        Response response8 = controller.doAction(request8);
        System.out.println(response8.getNotesInResponse());
        //testNoteBookConsoleView.print(response4.getNotesInResponse());
        
//        //Выводим на экран записную книгу
//        Request request5 = new Request("SHOW_NOTEBOOK");
//        Response response5 = controller.doAction(request5);
//        System.out.println(response5.getNoteBookInResponse());
//        System.out.println(response5.getNotesInResponse());
//        
//        //Записываем в файл записную книгу
//        Request request6 = new Request("WRITE_IN_FILE","notebook.txt");
//        Response response6 = controller.doAction(request6);
//        
//        //Читаем записную книгу
//        Request request7 = new Request("READ_FROM_FILE","notebook.txt");
//        Response response7 = controller.doAction(request7);
//        System.out.println(response7.getNotesInResponse());
        
	}

}
