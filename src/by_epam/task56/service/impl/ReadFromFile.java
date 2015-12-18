package by_epam.task56.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.entity.Note;
import by_epam.task56.service.InterfaceCommand;

public class ReadFromFile implements InterfaceCommand 
{
	
    //Метод разбивающий строку на требуемые данные
    static Note dataFromLine(String lineToParse) throws ParseException
    {
    	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
    	
    	Note noteFromReadedLine = new Note();//заводим пустой экземпляр записи Note
    	String [] dataFromStringLine;//заводим массив String для частей строки
    	dataFromStringLine = lineToParse.split("\t");//разбиваем строку по существующему правилу
    	
    	//Добавляем в нашу пустую запись Note конкретные данные
    	
    	noteFromReadedLine.setNoteText(dataFromStringLine[0]);//текст записи из строки
    	noteFromReadedLine.setNoteImportance(Integer.parseInt(dataFromStringLine[1]));//важность записи из строки
    	Date dateFromStringLine = dateFormatter.parse(dataFromStringLine[2]);//переводим дату записи в формате String из строки в формат Date
    	noteFromReadedLine.setNoteDate(dateFromStringLine);//дата из строки

		return noteFromReadedLine;//возвращаем заполненный данными экземпляр класса Note
    	
    }
    
    
	
	//Метод, возвращающий Response
    public Response execute(Request request) throws ServiceException
    {
       
        String pathToReadFile = request.getRequestContext();//путь к файлу для чтения
        
    	
    	ArrayList<Note> notesFromFile = new ArrayList<Note>();//заводим ArrayList для найденных записей
        
        
        try
        {
        	FileReader inputSteam = new FileReader(pathToReadFile);//создаем потоковый объект
        	@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(inputSteam);////буферизованный поток чтения
        	
            //построчное чтение из файла
        	String line;
            while ((line = bufferedReader.readLine()) != null)
            {
            	//System.out.println(line);
            	
				try 
				{
	            	Note singleNoteFromFile = ReadFromFile.dataFromLine(line);//создаем экземпляр записи Note на основании прочитанных данных из строки
					notesFromFile.add(singleNoteFromFile);  //добавляем в коллекцию записей конкретную запись 
				}
				catch (ParseException e) 
				{
					throw new ServiceException(e.getMessage());
				}
				
         	 
            }
            
            bufferedReader.close(); //закрываем наиболее вложенный поток
        }
        catch (IOException e) 
        {
        	throw new ServiceException(e.getMessage());
		}


        //Формируем Response
        Response response = new Response(notesFromFile);
        return response;
    }
    

    
}