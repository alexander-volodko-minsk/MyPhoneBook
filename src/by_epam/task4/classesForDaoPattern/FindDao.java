package by_epam.task4.classesForDaoPattern;

import java.util.ArrayList;

import by_epam.task3.entity.Note;

public interface FindDao
{
	public ArrayList<Note> findByDate(String Date);
	public ArrayList<Note> findByText(String context);
}
