package by_epam.task4.classesForDaoPattern;

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
	
	
	
	
    /* Придаем свойства интерфейса InsertUpdateDao объекту класса MemoryDaoFactory,
     * переопределяем метод абстрактного класса DaoFactory - getFindDao и getInsertUpdateDao
     */
	InsertUpdateDao insertUpdateDao = new MemoryInsertUpdateDao();

	
	
    public FindDao getFindDao()
    {
    	return MemoryFindDao.getInstance();
    }
    
    public InsertUpdateDao getInsertUpdateDao()
    {
    	return insertUpdateDao;
    }

}
