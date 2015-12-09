package by_epam.task04.controller;

import by_epam.task04.bean.to.Request;
import by_epam.task04.bean.to.Response;
import by_epam.task04.service.InterfaceCommand;
import by_epam.task04.service.ServiceHelper;

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
