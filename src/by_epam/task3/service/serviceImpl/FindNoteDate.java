package by_epam.task3.service.serviceImpl;

import java.util.ArrayList;
import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.entity.Note;
import by_epam.task3.service.InterfaceCommand;
import by_epam.task4.classesForDaoPattern.DaoFactory;
import by_epam.task4.classesForDaoPattern.FindDao;

public class FindNoteDate implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
    {
		
    	ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
    	String context = request.getRequestContext();//получаем строку для совпадения
    	
    	System.out.println("Try to find by date "+context);//выводим на консоль данные запроса
    	
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
