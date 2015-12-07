package by_epam.task3.controller;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.service.InterfaceCommand;
import by_epam.task3.service.ServiceHelper;

public class Controller 
{
	//создаем экземпляр класса helper
    private final static ServiceHelper helper = new ServiceHelper();
    
    
    //Метод, возвращающий Response
    public Response doAction(Request request)
    {
        String commandName = request.getCommandName();//получаем  имя команды из Request
        /*
         * Создаем ссылку базового класса(interface InterfaceCommand)
         * на объект производного(из HashMap commads экземпляр класса требуемой команды)
         */
        InterfaceCommand command = helper.getCommand(commandName); 
        
        Response response = command.execute(request);//выполняем переобределенную команду соответствующего класса
        return response;  //возвращаем Response                
    }


}
