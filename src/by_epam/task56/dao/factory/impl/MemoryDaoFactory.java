package by_epam.task56.dao.factory.impl;

import by_epam.task56.dao.FindDao;
import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.dao.factory.DaoFactory;
import by_epam.task56.dao.impl.memory.MemoryFindDao;
import by_epam.task56.dao.impl.memory.MemoryInsertUpdateDao;

//класс, наследуемый от абстракного класса DaoFactory
public class MemoryDaoFactory extends DaoFactory
{
	/*
	 * Singleton
	 * _____________________________
	 */
	private static MemoryDaoFactory instance = null;//статический экземпляр класса DaoFactory со ссылкой instance
	
	
	//Переопределяем констуктор по умолчанию
	private MemoryDaoFactory()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static MemoryDaoFactory getInstance()
	{
		if (instance == null) 
		{
			instance = new MemoryDaoFactory();
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
    	return MemoryFindDao.getInstance();
    }
    
    public InsertUpdateDao getInsertUpdateDao()
    {
    	return MemoryInsertUpdateDao.getInstance();
    }

}
