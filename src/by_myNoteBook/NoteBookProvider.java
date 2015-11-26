package by_myNoteBook;

public class NoteBookProvider 
{
	private static NoteBook instance;
	
	public static NoteBook getInstance()
	{
		if (instance == null) 
		{
			instance = new NoteBook();
			System.out.println("created");
		}
		else
		{
			System.out.println("!cannot created!-was created before");
		}
		return instance;
	}
}

