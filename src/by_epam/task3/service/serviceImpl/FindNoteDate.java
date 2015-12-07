package by_epam.task3.service.serviceImpl;

import java.util.ArrayList;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.dao.NoteBookProvider;
import by_epam.task3.entity.Note;
import by_epam.task3.entity.NoteBook;
import by_epam.task3.service.InterfaceCommand;

public class FindNoteDate implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    @SuppressWarnings("deprecation")
	public Response execute(Request request)
    {
    	System.out.println("try to find by date");
    	
    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        
        String context = request.getRequestContext();//получаем строку для совпадения
 
        //validate будет реализованно позже
        
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToFind = noteBook.getNotes();//получаем ArrayList <Notes>
        
        
        //ищем по всем записям notesToFind требуемую дату
        for(Note someNote : notesToFind)
        {
        	
        	Integer dateOfNote = someNote.getNoteDate().getDate();
        	Integer dayOfNote = someNote.getNoteDate().getDay();
        	String fullDateOfNote = dateOfNote.toString()+dayOfNote.toString();
        	System.out.println("note "+fullDateOfNote);
        	System.out.println("context "+context);
        	
        	if(context.equals(fullDateOfNote))
        	{
        		findedNotes.add(someNote);
        	}
        }
        
        //Формируем Response
        Response response = new Response(findedNotes);
        return response;
    }
    
}
