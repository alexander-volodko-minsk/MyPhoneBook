package by_epam.task56.controller;

import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.service.InterfaceCommand;
import by_epam.task56.service.ServiceHelper;
import by_epam.task56.service.impl.ServiceException;

public class Controller 
{
	//создаем экземпляр класса helper
    private final static ServiceHelper Helper = new ServiceHelper();
    
    
    //Метод, возвращающий Response
    public Response doAction(Request request) throws Exception
    {
        String commandName = request.getCommandName();//получаем  имя команды из Request
        /*
         * Создаем ссылку базового класса(interface InterfaceCommand)
         * на объект производного(из HashMap commads экземпляр класса требуемой команды)
         */
        InterfaceCommand command = Helper.getCommand(commandName); 
        
        //выполняем переобределенную команду соответствующего класса
        Response response = null;
		try 
		{
			response = command.execute(request);
		} 
		
		
		catch (ServiceException e) 
		{
			System.out.println(e.getMessage());
		}
		
        return response;  //возвращаем Response                
    }


}
