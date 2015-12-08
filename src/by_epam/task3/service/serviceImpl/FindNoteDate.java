package by_epam.task3.service.serviceImpl;

import java.text.SimpleDateFormat;
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
    public Response execute(Request request)
    {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        
        String context = request.getRequestContext();//получаем строку для совпадения
        
        System.out.println("Try to find by date");
        System.out.println(context);
 
        //validate будет реализованно позже
        
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToFind = noteBook.getNotes();//получаем ArrayList <Notes>
        
        
        //ищем по всем записям notesToFind требуемую дату
        for(Note someNote : notesToFind)
        {
        	
        	//формируем из аттрибутов Date строку для сравнения со строкой Request
        	String fullDateOfNote = dateFormatter.format(someNote.getNoteDate());

        	//добавляем в коллекцию подходящие записи
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
