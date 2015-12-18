package by_epam.task56.service.impl;

@SuppressWarnings("serial")
public class ServiceException extends Exception
{
	public ServiceException(String message)
	{
		super(message);
	}
	
	public ServiceException(String message, Exception e)
	{
		super(message, e);
	}

}
