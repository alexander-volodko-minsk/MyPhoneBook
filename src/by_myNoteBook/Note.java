package by_myNoteBook;

import java.util.Date;

public class Note 
{
	private String noteText, noteImportance;
	//private int sequenceNumber;
	private Date noteDate;

	public Note ()
	{
		this.noteText=" ";
		this.noteDate=new Date();
		this.noteImportance="regular";
	}
	
	public Note (String noteText)
	{
		this.noteText=noteText;
		this.noteDate=new Date();
		this.noteImportance="regular";
	}
	
	public Note (String noteText, String noteImportance)
	{
		this.noteText=noteText;
		this.noteDate=new Date();
		this.noteImportance=noteImportance;
	}
	
	public Note (String noteText, String noteImportance, Date noteDate)
	{
		this.noteText=noteText;
		this.noteDate=noteDate;
		this.noteImportance=noteImportance;
	}
	
	//NoteText
	//getNoteText
	public String getNoteText ()
	{
		return noteText;
	}

	//setNoteText
	public void setNoteText (String noteText)
	{
		this.noteText=noteText;
	}
	
	
	//NoteImportance
	//getNoteImportance
	public String getNoteImportance ()
	{
		return noteImportance;
	}

	//setNoteImportance
	public void setNoteImportance (String noteImportance)
	{
		this.noteImportance=noteImportance;
	}
	
	/*
	//SequenceNumber
	//getSequenceNumber
	public int getSequenceNumber (String noteText)
	{
		return sequenceNumber;
	}
	//setSequenceNumber
	public void setSequenceNumber (int sequenceNumber)
	{
		this.sequenceNumber=sequenceNumber;
	}		
	*/
	
	//NoteDate
	//getNoteDate
	public Date getNoteDate ()
	{
		return noteDate;
	}	
	
	//setNoteDate
	public void setNoteDate (Date noteDate)
	{
		this.noteDate=noteDate;
	}	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noteDate == null) ? 0 : noteDate.hashCode());
		result = prime * result + ((noteImportance == null) ? 0 : noteImportance.hashCode());
		result = prime * result + ((noteText == null) ? 0 : noteText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (noteDate == null) 
		{
			if (other.noteDate != null)
				return false;
		} 
		else if (!noteDate.equals(other.noteDate))
			return false;
		if (noteImportance == null)
		{
			if (other.noteImportance != null)
				return false;
		} 
		else if (!noteImportance.equals(other.noteImportance))
			return false;
		if (noteText == null)
		{
			if (other.noteText != null)
				return false;
		} 
		else if (!noteText.equals(other.noteText))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Note [noteText=" + noteText + ", noteImportance=" + noteImportance + ", noteDate=" + noteDate + "]";
	}
	
	

}
