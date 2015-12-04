package com_epam.task3.classesForCommands;

import java.util.HashMap;

public class ServiceHelper
{
    private HashMap<CommandName, InterfaceCommand> commands = new HashMap<>();
    
    
    public ServiceHelper()
    {
    	commands.put(CommandName.ADD_NEW_NOTE, new AddNewNote());
    }
    
    public InterfaceCommand getCommand(String commandName)
    {
        CommandName name = CommandName.valueOf(commandName);
        InterfaceCommand command = commands.get(name);
        
        return command;
    }

 
}
