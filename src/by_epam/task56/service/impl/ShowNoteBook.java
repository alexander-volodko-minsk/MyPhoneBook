package by_epam.task56.service.impl;

import by_epam.task56.dao.NoteBookProvider;
import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.entity.NoteBook;
import by_epam.task56.service.InterfaceCommand;

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
