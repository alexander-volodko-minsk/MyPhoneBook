package by_epam.task4.classesForDaoPattern;

import java.util.ArrayList;

import by_epam.task3.entity.Note;

//Интерфейс добавления записи
public interface InsertUpdateDao 
{
	public ArrayList<Note> addNewNote(String context);
}
