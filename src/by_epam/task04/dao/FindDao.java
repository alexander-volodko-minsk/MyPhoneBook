package by_epam.task04.dao;

import java.util.ArrayList;

import by_epam.task04.entity.Note;

public interface FindDao
{
	public ArrayList<Note> findByDate(String Date);
	public ArrayList<Note> findByText(String context);
}
