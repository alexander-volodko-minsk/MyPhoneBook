package com_epam.task3.classesForCommands;

//import java.util.Date;

public class Request
{
	//Поля класса
	private String commandName;
    private String requestContext;
    //private Date commandDate;
    
    
    //Конструктор класса Request
    public Request(String commandName, String requestContext)
    {
    	this.commandName = commandName;
    	this.requestContext = requestContext;
    	//this.commandDate = new Date();
    }
    
    
    
    
    //Сеттеры и геттеры класса Request
    //commandName
	public String getCommandName() 
	{
		return commandName;
	}
	public void setCommandName(String commandName) 
	{
		this.commandName = commandName;
	}
	
	//requestContext
	public String getRequestContext()
	{
		return requestContext;
	}
	public void setRequestContext(String requestContext)
	{
		this.requestContext = requestContext;
	}
	
}