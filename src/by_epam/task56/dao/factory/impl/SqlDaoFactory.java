package by_epam.task56.dao.factory.impl;

import by_epam.task56.dao.FindDao;
import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.dao.factory.DaoFactory;
import by_epam.task56.dao.impl.sql.SqlFindDao;
import by_epam.task56.dao.impl.sql.SqlInsertUpdateDao;

//класс, наследуемый от абстракного класса DaoFactory
public class SqlDaoFactory extends DaoFactory
{
	/*
	 * Singleton
	 * _____________________________
	 */
	private static SqlDaoFactory instance = null;//статический экземпляр класса DaoFactory со ссылкой instance
	
	
	//Переопределяем констуктор по умолчанию
	private SqlDaoFactory()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static SqlDaoFactory getInstance()
	{
		if (instance == null) 
		{
			instance = new SqlDaoFactory();
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
  	return SqlFindDao.getInstance();
  }
  
  public InsertUpdateDao getInsertUpdateDao()
  {
  	return SqlInsertUpdateDao.getInstance();
  }

}

