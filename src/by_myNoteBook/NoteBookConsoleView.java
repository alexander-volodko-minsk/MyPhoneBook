package by_myNoteBook;


public class NoteBookConsoleView 
{
	private NoteBook noteBook;
	
    //Коструктор класса, передающий ArrayList
	public NoteBookConsoleView(NoteBook noteBook)
	{
		this.noteBook=noteBook;
	}
	
	public void viewAllOfNotes()
	{
		for ( Note note : noteBook.getNotes())
		{
			note.toString();
		}
	}
	
	public void viewListOfNotes(Note ... args)
	{
		for ( Note note : args)
		{
			note.toString();
		}
	}

}
