package by_epam.task04.dao.impl.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import by_epam.task04.dao.FindDao;
import by_epam.task04.dao.impl.memory.MemoryFindDao;
import by_epam.task04.entity.Note;

public class FileFindDao implements FindDao

{
	
	/*
	 * Singleton
	 * _____________________________
	 */
	private static FileFindDao instance = null;//статический экземпляр класса DaoFactory со ссылкой instance
	
	
	//Переопределяем констуктор по умолчанию
	private FileFindDao()
	{

	}
	
	/*
	 * Статический метод, создающий экземпляр класса NoteBookProvider со ссылкой instance
	 * или возвращающий уже созданный instance
	 */
	public static FileFindDao getInstance()
	{
		if (instance == null) 
		{
			instance = new FileFindDao();
		}
		return instance;
	}
	/*
     * _____________________________
	 * Singleton
	 */
	
 
	
	//Метод, переводящий дату из Date в String
	static public String dateInString(Date someDate)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
		String dateInString = dateFormatter.format(someDate);//переводим в String требуемого формата данные типа Date
		return dateInString;
	}
	
	
    
    //переопределенный метод интерфейса FindDao
	@Override
	public ArrayList<Note> findByText(String context) 
	{
		ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        ArrayList<Note> notesToFind = FileFindDao.readFromFile("notebook.txt");//получаем ArrayList <Notes> из файла
        
        //ищем по всем записям notesToFind требуемую строку
        for(Note someNote : notesToFind)
        {
        	if(context.equals(someNote.getNoteText()))
        	{
        		findedNotes.add(someNote);
        	}
        }
		return findedNotes;	
	}
	
    //переопределенный метод интерфейса FindDao
	@Override
	public ArrayList<Note> findByDate(String context) 
	{
		ArrayList<Note> findedNotes = new ArrayList<Note>();//заводим ArrayList для найденных записей
        ArrayList<Note> notesToFind = FileFindDao.readFromFile("notebook.txt");//получаем ArrayList <Notes> из файла
        
        //ищем по всем записям notesToFind требуемую строку
        //ищем по всем записям notesToFind требуемую дату
        for(Note someNote : notesToFind)
        {
        	Date dateOfNoteInDate = someNote.getNoteDate();//получаем Date записи
        	
        	//формируем из аттрибутов Date строку для сравнения со строкой Request
        	String dateOfNoteInString = MemoryFindDao.dateInString(dateOfNoteInDate);

        	//добавляем в коллекцию подходящие записи
        	if(context.equals(dateOfNoteInString))
        	{
        		findedNotes.add(someNote);
        	}
        }
		return findedNotes;
	}
	
	
    //Метод разбивающий строку на требуемые данные по определенному правилу
    public static Note dataFromLine(String lineToParse) throws ParseException
    {
    	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");//заводим форматтер даты
    	
    	Note noteFromReadedLine = new Note();//заводим пустой экземпляр записи Note
    	String [] dataFromStringLine;//заводим массив String для частей строки
    	dataFromStringLine = lineToParse.split("\t");//разбиваем строку по существующему правилу
    	
    	//Добавляем в нашу пустую запись Note конкретные данные
    	
    	noteFromReadedLine.setNoteText(dataFromStringLine[0]);//текст записи из строки
    	noteFromReadedLine.setNoteImportance(Integer.parseInt(dataFromStringLine[1]));//важность записи из строки
    	Date dateFromStringLine = dateFormatter.parse(dataFromStringLine[2]);//переводим дату записи в формате String из строки в формат Date
    	noteFromReadedLine.setNoteDate(dateFromStringLine);//дата из строки

		return noteFromReadedLine;//возвращаем заполненный данными экземпляр класса Note
    	
    }
    
    
    //метод, читающий по произвольному правилу данные из файла
    public static ArrayList<Note> readFromFile(String pathToReadFile)
    {
    	ArrayList<Note> notesFromFile = new ArrayList<Note>();//заводим ArrayList для найденных записей
        
        try
        {
        	FileReader inputSteam = new FileReader(pathToReadFile);//создаем потоковый объект
        	BufferedReader bufferedReader = new BufferedReader(inputSteam);////буферизованный поток чтения
        	
            //построчное чтение из файла
        	String line;
            while ((line = bufferedReader.readLine()) != null)
            {
            	
				try 
				{
	            	Note singleNoteFromFile = FileFindDao.dataFromLine(line);//создаем экземпляр записи Note на основании прочитанных данных из строки
					notesFromFile.add(singleNoteFromFile);  //добавляем в коллекцию записей конкретную запись 
				}
				catch (ParseException e) 
				{
					System.out.println(e.getMessage());
				}

            }
            
            bufferedReader.close(); //закрываем наиболее вложенный поток
        }
        catch (IOException e) 
        {
			System.out.println(e.getMessage());
		}
        
		return notesFromFile;
    }


}
