package by_epam.task3.service.serviceImpl;

import java.util.ArrayList;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.dao.NoteBookProvider;
import by_epam.task3.entity.Note;
import by_epam.task3.entity.NoteBook;
import by_epam.task3.service.InterfaceCommand;

public class AddNewNote implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
        
        String context = request.getRequestContext();
 
        //validate будет реализованно позже
        
        Note note = new Note(context);//создаем запись для добавления по context из Request
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        ArrayList<Note> notesToAdd = noteBook.getNotes();//получаем ArrayList <Notes>
        notesToAdd.add(note);//добавляем запись в ArrayList экземпляра NoteBook
        
        
        //Формируем Response
        Response response = new Response(noteBook);
        response.setNoteBookInResponse(noteBook);
        return response;
    }


}
