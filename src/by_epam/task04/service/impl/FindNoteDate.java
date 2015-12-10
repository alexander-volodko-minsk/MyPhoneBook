package by_epam.task04.service.impl;

import java.util.ArrayList;

import by_epam.task04.bean.to.Request;
import by_epam.task04.bean.to.Response;
import by_epam.task04.dao.FindDao;
import by_epam.task04.dao.factory.DaoFactory;
import by_epam.task04.entity.Note;
import by_epam.task04.service.InterfaceCommand;

public class FindNoteDate implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
		
    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
    	String context = request.getRequestContext();//получаем строку для совпадения
    	
    	
        /* Cоздаем ссылку абстрактного класса DaoFactory на объект производного (Memory/File)DaoFactory,
         * который определяет источник данных; 
         * (какой именно источник данных должен использоваться компилятор поймет сам)
         */
        DaoFactory daoFactory = DaoFactory.getFactory();
        
        /* Придаем свойства интерфейса FindDao объекту класса (Memory/File)DaoFactory,
         * вызываем instance(Memory/File)FindDao
         * (какой именно источник данных должен использоваться компилятор поймет сам)
         * и вызываем на нем соответстующий метод findByDate.
         */
        FindDao findDao = daoFactory.getFindDao();
        
        //получаем подходящие записи
        findedNotes = findDao.findByDate(context);
 
        //validate будет реализованно позже

        
        //Формируем Response
        Response response = new Response(findedNotes);
        return response;
    }
    
    
}
