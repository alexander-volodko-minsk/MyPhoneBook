package by_epam.task56.dao;

import java.util.ArrayList;

import by_epam.task56.entity.Note;

//Интерфейс добавления записи
public interface InsertUpdateDao 
{
	public ArrayList<Note> addNewNote(String context) throws DaoException;
}
