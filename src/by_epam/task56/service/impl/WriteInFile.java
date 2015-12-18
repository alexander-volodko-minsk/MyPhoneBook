package by_epam.task56.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import by_epam.task56.dao.NoteBookProvider;
import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.entity.Note;
import by_epam.task56.entity.NoteBook;
import by_epam.task56.service.InterfaceCommand;

public class WriteInFile implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request) throws ServiceException
    {
        
       
        String pathToWriteFile = request.getRequestContext();//путь к файлу для записи
        
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();//получаем экземпляр NoteBook
        
        
        //записываем полученный экземпляр записной книги в файл
        try 
        {
			FileWriter outPutSteam = new FileWriter(pathToWriteFile);//создаем потоковый объект
	        BufferedWriter bufferedWriter = new BufferedWriter(outPutSteam);//буферизованный оток ввода
	        PrintWriter printWriter = new PrintWriter(bufferedWriter); //усовершенствованная работа с символами UNICODE
	        
	        
	        //построчная запись в файл
	        for(Note someNote : noteBook.getNotes())
	        {
	        	printWriter.println(someNote);//запись одного Note 
	        }

	        printWriter.close();//закрываем наиболее вложенный поток
		}
        
        catch (IOException e) 
        {
        	throw new ServiceException(e.getMessage());
		}
        
        //Формируем Response
        Response response = new Response(noteBook);
        return response;
    }
    
}
