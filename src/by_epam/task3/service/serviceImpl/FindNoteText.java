package by_epam.task3.service.serviceImpl;

import java.util.ArrayList;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.dao.NoteBookProvider;
import by_epam.task3.entity.Note;
import by_epam.task3.entity.NoteBook;
import by_epam.task3.service.InterfaceCommand;

public class FindNoteText implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
    	
    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        
        String context = request.getRequestContext();//получаем строку для совпадения
        
        System.out.println("Try to find by text");
        System.out.println(context);
 
        //validate будет реализованно позже
        
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToFind = noteBook.getNotes();//получаем ArrayList <Notes>
        
        //ищем по всем записям notesToFind требуемую строку
        for(Note someNote : notesToFind)
        {
        	if(context.equals(someNote.getNoteText()))
        	{
        		findedNotes.add(someNote);
        	}
        }
        
        //Формируем Response
        Response response = new Response(findedNotes);
        return response;
    }
    
}
