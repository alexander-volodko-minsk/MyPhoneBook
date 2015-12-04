package com_epam.task3.classesForCommands;

import by_epam.task2.dao.memory.NoteBookProvider;
import by_epam.task2.entity.Note;
import by_epam.task2.entity.NoteBook;

public class AddNewNote implements InterfaceCommand 
{
    public Response execute(Request request)
    {
        
        String context = request.getRequestContext();
      //  String commandName = request.getCommandName();
 
        //validate
        
        Note note = new Note(context);
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.add(note);
        
        Response response = new Response(note, noteBook.getNotes(), noteBook);
        response.setNoteBookInResponse(noteBook);
        return response;
    }


}
