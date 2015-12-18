package by_epam.task56.service.impl;

import java.util.ArrayList;

import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.dao.DaoException;
import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.dao.factory.DaoFactory;
import by_epam.task56.entity.Note;
import by_epam.task56.service.InterfaceCommand;

//класс, имплеменченный от интерфейса InterfaceCommand
public class AddNewNote implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request) throws ServiceException
    {

        String context = request.getRequestContext();
        ArrayList<Note> updatedNotes = new ArrayList<Note>();//заводим обновляемую коллекцию
 
        //validate будет реализованно позже
 

        /* Cоздаем ссылку абстрактного класса DaoFactory на объект производного (Memory/File)DaoFactory,
         * который определяет источник данных; 
         * (какой именно источник данных должен использоваться компилятор поймет сам)
         */
        DaoFactory daoFactory = DaoFactory.getFactory();
        

        /* Придаем свойства интерфейса InsertUpdateDao объекту класса (Memory/File)DaoFactory,
         * вызываем instance(Memory/File)InsertUpdateDao
         * (какой именно источник данных должен использоваться компилятор поймет сам)
         * и вызываем на нем соответстующий метод addNewNote.
         */
        InsertUpdateDao insertUpdateDao = daoFactory.getInsertUpdateDao();//
        //добавляем запись в коллекцию
        try 
        {
        	//метод переопределенный от интерфейса InsertUpdateDao в классе MemoryInsertUpdateDao
			updatedNotes = insertUpdateDao.addNewNote(context);
		}
        catch (DaoException e)
        {
        	throw new ServiceException(e.getMessage());
		}
      

        
        //Формируем Response
        Response response = new Response(updatedNotes);
        return response;
    }


}
