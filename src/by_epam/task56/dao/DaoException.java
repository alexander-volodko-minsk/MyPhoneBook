package by_epam.task56.dao;

@SuppressWarnings("serial")
public class DaoException extends Exception
{
	public DaoException(String message)
	{
		super(message);
	}
	
	public DaoException(String message, Exception e)
	{
		super(message, e);
	}

}
