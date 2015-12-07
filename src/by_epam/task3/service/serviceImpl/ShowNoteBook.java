package by_epam.task3.service.serviceImpl;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.dao.NoteBookProvider;
import by_epam.task3.entity.NoteBook;
import by_epam.task3.service.InterfaceCommand;

public class ShowNoteBook implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
        
        System.out.println("Show the notebook");
        
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        
        //Формируем Response
        Response response = new Response(noteBook);
        return response;
    }
    
}
