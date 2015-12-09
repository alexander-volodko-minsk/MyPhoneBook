package by_epam.task3.service.serviceImpl;

import java.util.ArrayList;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.entity.Note;
import by_epam.task3.service.InterfaceCommand;
import by_epam.task4.classesForDaoPattern.FindDao;
import by_epam.task4.classesForDaoPattern.DaoFactory;

public class FindNoteText implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
    	
        String context = request.getRequestContext();//получаем строку для совпадения
        
        System.out.println("Try to find by text "+context);
        
        
        /* Cоздаем ссылку абстрактного класса DaoFactory на объект производного (Memory/File)DaoFactory,
         * который определяет источник данных; 
         * (какой именно источник данных должен использоваться компилятор поймет сам)
         */
        DaoFactory daoFactory = DaoFactory.getFactory();
        
        /* Придаем свойства интерфейса FindDao объекту класса (Memory/File)DaoFactory,
         * вызываем instance(Memory/File)FindDao
         * (какой именно источник данных должен использоваться компилятор поймет сам)
         * и вызываем на нем соответстующий метод findByText.
         */
        FindDao findDao = daoFactory.getFindDao();
        
        //получаем подходящие записи
        ArrayList<Note> findedNotes = findDao.findByText(context);
        
        //Формируем Response
        Response response = new Response(findedNotes);
        return response;


    }
    
}
