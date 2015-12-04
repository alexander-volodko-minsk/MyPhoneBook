package com_epam.task3.classesForCommands;

public class Controller 
{
    private final static ServiceHelper helper = new ServiceHelper();
    
    public Response doAction(Request request)
    {
        String commandName = request.getCommandName();
        InterfaceCommand command = helper.getCommand(commandName);
        Response response = command.execute(request);
        return response;                  
    }


}
