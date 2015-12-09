package by_epam.task3.service.serviceImpl;

import java.util.ArrayList;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;
import by_epam.task3.entity.Note;
import by_epam.task3.service.InterfaceCommand;
import by_epam.task4.classesForDaoPattern.DaoFactory;
import by_epam.task4.classesForDaoPattern.InsertUpdateDao;

//класс, имплеменченный от интерфейса InterfaceCommand
public class AddNewNote implements InterfaceCommand 
{
	
	//Метод, возвращающий Response
    public Response execute(Request request)
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
        updatedNotes = insertUpdateDao.addNewNote(context);//метод переопределенный от интерфейса InsertUpdateDao в классе MemoryInsertUpdateDao
        
        //Формируем Response
        Response response = new Response(updatedNotes);
        return response;
    }


}
