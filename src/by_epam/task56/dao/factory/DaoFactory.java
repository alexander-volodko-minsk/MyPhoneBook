package by_epam.task56.dao.factory;

import by_epam.task56.dao.FindDao;
import by_epam.task56.dao.InsertUpdateDao;
import by_epam.task56.dao.factory.impl.FileDaoFactory;
import by_epam.task56.dao.factory.impl.MemoryDaoFactory;
import by_epam.task56.dao.factory.impl.SqlDaoFactory;

//абстрактный класс, от которого наследуются MemoryDaoFactory и FileDaoFactory
public abstract class DaoFactory 
{
	
	private static final String Type = "sql";//тип источника данных для работы с записной книгой
	
	
	//метод, определяющий источник информации для работы с записной книгой
	public static DaoFactory getFactory()
	{
		
		switch(Type)
		{	
        	case "memory": 
        	
        		return MemoryDaoFactory.getInstance();

            case "file":
            
            	return FileDaoFactory.getInstance();
            	
            case "sql":
                
            	return SqlDaoFactory.getInstance();	

            default :
            	return MemoryDaoFactory.getInstance();
		}
		
  
	}
	
	//методы, которые будут переопределены в наследуемых классах MemoryDaoFactory, FileDaoFactory, SqlDaoFactory
	public abstract FindDao getFindDao();
	public abstract InsertUpdateDao getInsertUpdateDao();

}
