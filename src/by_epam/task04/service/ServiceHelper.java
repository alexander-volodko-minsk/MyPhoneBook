package by_epam.task04.service;

import java.util.HashMap;

import by_epam.task04.service.impl.AddNewNote;
import by_epam.task04.service.impl.FindNoteDate;
import by_epam.task04.service.impl.FindNoteText;
import by_epam.task04.service.impl.ReadFromFile;
import by_epam.task04.service.impl.ShowNoteBook;
import by_epam.task04.service.impl.WriteInFile;

/*
*  helper имеет в качестве своего поля HashMap<CommandName, InterfaceCommand> commands, в которой хранятся в 
*  качестве ключей - имена комманд из enum CommandName, а в качестве значений - реализации InterfaceCommand.
*     
*  А так же метод InterfaceCommand getCommand(String commandName), возвращающий экземпляр класса требуемой команды
*  из HashMap commands.
*/

public class ServiceHelper
{
    private HashMap<CommandName, InterfaceCommand> commands = new HashMap<>();//CommandName - из enum
    
    //Конструктор класса, помещающий в HashMap пары значений(команда-соответвующий реализации экземпляр класс)
    public ServiceHelper()
    {
    	commands.put(CommandName.ADD_NEW_NOTE, new AddNewNote());
    	commands.put(CommandName.FIND_NOTE_TEXT, new FindNoteText());
    	commands.put(CommandName.FIND_NOTE_DATE, new FindNoteDate());
    	commands.put(CommandName.SHOW_NOTEBOOK, new ShowNoteBook());
    	commands.put(CommandName.WRITE_IN_FILE, new WriteInFile());
    	commands.put(CommandName.READ_FROM_FILE, new ReadFromFile());
    }
    
    //метод, возвращающий экземпляр класса требуемой команды 
    public InterfaceCommand getCommand(String commandName)
    {
        CommandName name = CommandName.valueOf(commandName);//получение из enum CommandName имени команды по String commandName из Request
        InterfaceCommand command = commands.get(name);//по ключу получаем экземпляр класса требуемой команды 
        
        return command;//возвращаю экземпляр класса требуемой команды 
    }

 
}
