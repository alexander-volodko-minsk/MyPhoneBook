package by_epam.task04.service.impl;

import by_epam.task04.bean.to.Request;
import by_epam.task04.bean.to.Response;
import by_epam.task04.dao.NoteBookProvider;
import by_epam.task04.entity.NoteBook;
import by_epam.task04.service.InterfaceCommand;

public class ShowNoteBook implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
        
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        
        //Формируем Response
        Response response = new Response(noteBook);
        return response;
    }
    
}
