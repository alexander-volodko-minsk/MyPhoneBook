package by_epam.task4.classesForDaoPattern;

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
	
	
    
    /* Придаем свойства интерфейса InsertUpdateDao объекту класса MemoryDaoFactory,
     * переопределяем метод абстрактного класса DaoFactory - getFindDao и getInsertUpdateDao
     */
    InsertUpdateDao insertUpdateDao = new FileInsertUpdateDao();

    
    
    public FindDao getFindDao()
    {
    	return FileFindDao.getInstance();
    }
    
    public InsertUpdateDao getInsertUpdateDao()
    {
    	return insertUpdateDao;
    }


}
