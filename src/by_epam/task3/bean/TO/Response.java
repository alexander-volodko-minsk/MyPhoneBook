package by_epam.task3.bean.TO;

import java.util.ArrayList;

import by_epam.task3.entity.Note;
import by_epam.task3.entity.NoteBook;

public class Response 
{
	
	//Поля класса
	private Note noteInResponse;
	private ArrayList<Note> notesListInResponse;
	private NoteBook noteBookInResponse;
	
	/*
	//Конструктор класса
	public Response(Note noteInResponse, ArrayList<Note> notesListInResponse, NoteBook noteBookInResponse) 
	{
		this.noteInResponse = noteInResponse;
		this.notesListInResponse = notesListInResponse;
		this.noteBookInResponse = noteBookInResponse;
	}
	*/
	
	//Конструктор класса
	
	public Response(NoteBook noteBookInResponse) 
	{
		this.noteBookInResponse = noteBookInResponse;
	}
	
	public Response(ArrayList<Note> notesListInResponse) 
	{
		this.notesListInResponse = notesListInResponse;
	}
	
	
	
    //Сеттеры и геттеры класса Response
    //noteInResponse
	public Note getNoteInResponse() 
	{
		return noteInResponse;
	}
	public void setNoteInResponse(Note noteInResponse)
	{
		this.noteInResponse = noteInResponse;
	}
	
	//notesListInResponse
	public ArrayList<Note> getNotesInResponse()
	{
		return notesListInResponse;
	}
	public void setNotesInResponse(ArrayList<Note> notesInResponse)
	{
		this.notesListInResponse = notesInResponse;
	}
	
	//noteBookInResponse
	public NoteBook getNoteBookInResponse()
	{
		return noteBookInResponse;
	}
	public void setNoteBookInResponse(NoteBook noteBookInResponse) 
	{
		this.noteBookInResponse = noteBookInResponse;
	}
	
}