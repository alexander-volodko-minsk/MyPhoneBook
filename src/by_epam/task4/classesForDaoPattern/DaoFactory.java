package by_epam.task4.classesForDaoPattern;

//абстрактный класс, от которого наследуются MemoryDaoFactory и FileDaoFactory
public abstract class DaoFactory 
{
	
	private static final String type = "file";//тип источника данных для работы с записной книгой
	
	
	//метод, определяющий источник информации для работы с записной книгой
	public static DaoFactory getFactory()
	{
		
		switch(type)
		{	
        	case "memory": 
        	
        		return MemoryDaoFactory.getInstance();
        		//break;

            case "file":
            
            	return FileDaoFactory.getInstance();
            	//break;	

            default :
            	return MemoryDaoFactory.getInstance();
		}
		
  
	}
	
	//методы, которые будут переопределены в наследуемых классах MemoryDaoFactory и FileDaoFactory
	public abstract FindDao getFindDao();
	public abstract InsertUpdateDao getInsertUpdateDao();

}
