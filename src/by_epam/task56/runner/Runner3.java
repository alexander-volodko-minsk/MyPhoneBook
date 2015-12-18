package by_epam.task56.runner;

import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.controller.Controller;


public class Runner3 
{

	public static void main(String[] args) throws Exception 
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

        Request request1 = new Request("ADD_NEW_NOTE","same text");
        Response response1 = controller.doAction(request1);
        Request request2 = new Request("ADD_NEW_NOTE","Text To Find");
        Response response2 = controller.doAction(request2);
        Request request3 = new Request("ADD_NEW_NOTE","same text");
        Response response3 = controller.doAction(request3);
        Request request4 = new Request("ADD_NEW_NOTE","text");
        Response response4 = controller.doAction(request4);
       
        Request request7 = new Request("FIND_NOTE_TEXT","Text To Find");
        Response response7 = controller.doAction(request7);
        System.out.println(response7.getNotesInResponse());
        
        Request request8 = new Request("FIND_NOTE_DATE","11.11.1111");
        Response response8 = controller.doAction(request8);
        System.out.println(response8.getNotesInResponse());

        
	}

}
