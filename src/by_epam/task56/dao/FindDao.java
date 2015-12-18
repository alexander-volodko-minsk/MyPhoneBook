package by_epam.task56.dao;

import java.util.ArrayList;

import by_epam.task56.entity.Note;

//интерфейс поиска записи
public interface FindDao
{
	public ArrayList<Note> findByDate(String Date) throws DaoException;
	public ArrayList<Note> findByText(String context) throws DaoException;
}
