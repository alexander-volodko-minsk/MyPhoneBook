package by_epam.task04.dao.factory.impl;

import by_epam.task04.dao.FindDao;
import by_epam.task04.dao.InsertUpdateDao;
import by_epam.task04.dao.factory.DaoFactory;
import by_epam.task04.dao.impl.file.FileFindDao;
import by_epam.task04.dao.impl.file.FileInsertUpdateDao;

public class FileDaoFactory extends DaoFactory 
{
	
	
	/*
	 * Singleton
	 * _____________________________
	 */
	private static FileDaoFactory instance = null;//статический экземпляр класса DaoFactory со ссылкой instance
	
	
	//Переопределяем констуктор по умолчанию
	private FileDaoFactory()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static FileDaoFactory getInstance()
	{
		if (instance == null) 
		{
			instance = new FileDaoFactory();
		}
		return instance;
	}
	/*
     * _____________________________
	 * Singleton
	 */
	
	

    //переопределяем метод абстрактного класса DaoFactory - getFindDao и getInsertUpdateDao
	
    public FindDao getFindDao()
    {
    	return FileFindDao.getInstance();
    }
    
    public InsertUpdateDao getInsertUpdateDao()
    {
    	return FileInsertUpdateDao.getInstance();
    }


}
