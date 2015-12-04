package by_epam.task2.entity;

import java.util.Date;


/*
 * ����� Note, �������������� ����� ��������� ������.
 * � �������� ����� ������ ������������:
 * noteText, noteImportance, noteDate
 */


public class Note 
{
	
	/*
	 * ���� ������
	 * ___________
	 */
	private String noteText;//����� ������
	private int noteImportance;//�������� ������
	private Date noteDate;//���� ������
	/*
	 *___________
	 * ���� ������
	 */
	
	
	
	/*
	 * ������� � ������� ����� ������
	 * ______________________________
	 */
	//getNoteText
	public String getNoteText ()
	{
		return noteText;
	}
	//setNoteText
	public void setNoteText (String noteText)
	{
		this.noteText=noteText;
	}
	
	
	//getNoteImportance
	public int getNoteImportance ()
	{
		return noteImportance;
	}
	//setNoteImportance
	public void setNoteImportance (int noteImportance)
	{
		this.noteImportance=noteImportance;
	}
	
	
	//getNoteDate
	public Date getNoteDate ()
	{
		return noteDate;
	}	
	//setNoteDate
	public void setNoteDate (Date noteDate)
	{
		this.noteDate=noteDate;
	}
	/*
	 * ______________________________
	 * ������� � ������� ����� ������
	 */

	
	
	/*
	 * ������������ ������
	 * ___________________
	 */
	//�������� ������ � ��������� ������ ������ ������
	public Note (String noteText)
	{
		this.noteText=noteText;
		this.noteDate=new Date();//���� ������������ �������� ������� ����
		this.noteImportance=0;//�������� �������� ������ �� ��������� ����� "0"
	}
	
	//�������� ������ � ��������� ������ ������ � �� ��������
	public Note (String noteText, int noteImportance)
	{
		this.noteText=noteText;//����� ������ ���������� � �������� ��������� ������������
		this.noteDate=new Date();//���� ������������ �������� ������� ����
		this.noteImportance=noteImportance;//�������� ������ ���������� � �������� ��������� ������������
	}
	/*
	 * ___________________
	 * ������������ ������
	 */
	
	


	/*
	 * �������������� ����� toString ��� ������ Note
	 * ������������ ��� ���� ����� ������������ ������ ���� �� �������, ������ ������ ���
	 * __________________________________________________________________________________
	 */
	@Override
	public String toString()
	{
		StringBuilder build = new StringBuilder();//������� ������, ������� ����� ��������� ��� ����������
		
		build.append("class=");
		build.append(this.getClass().getName());//�������� ��� ������
		
		build.append(";noteText=");
		build.append(this.noteText);//�������� ����� ������
		
		build.append(";noteImportance=");
		build.append(this.noteImportance);//�������� �������� ������
		
		build.append(";noteDate=");
		build.append(this.noteDate);//�������� ���� ������

		return build.toString();//���������� �������������� ������
	}
	/*
	 * �������������� ����� toString ��� ������ Note
	 * __________________________________________________________________________________
	 */

	
	
	
	
	/*
	 * �������������� ����� hashCode ��� ������ Note
	 * _____________________________________________
	 */
	@Override
	public int hashCode() 
	{
		/*
		 * ��������� ������� ������� ���� ������ ���������� �� ������� �����
		 * (����������� ������ �� ����� �������, ������� ���������� �� �������� ��������)
		 */

		return 9*noteText.hashCode()+7*noteImportance+23*noteDate.hashCode();
	}
	/*
	 * _____________________________________________
	 * �������������� ����� hashCode ��� ������ Note
	 */

	
	
	/*
	 * �������������� ����� equals ��� ������ Note
	 * ___________________________________________
	 */
	@Override
	public boolean equals(Object obj) 
	/*
	 *�������� ����������� Object, ��� ��� � ������� Object ���������� Object, 
	 *� ��� ���� ��������������, ������ ��������� ����� ��������
	 */
	{
		//��������� �� ������ (this � ������ ������ ������������ ����� Object obj)
		if (this == obj)
		{
			return true;
		}
		
		
		//null ��������, ��� ������ �� ��������� �� �� ����� ������
		if (obj == null)
		{
			return false;
		}
		
		
		/*
		 * ���������� ������ ��������,
		 * ��� ��� ��������� � ��������� ������ �������� ����� ���� ���������
		 */
		if (getClass() != obj.getClass())
		{
			return false;
		}	
		
		
		/*
		 * //������� ������ Note �� ������� other, �������� � ������ ������, ����� �������� ����
		 */
		Note other = (Note) obj;
		
		/*
		 * ��������� ����� ��������
		 * (����� noteDate, noteText, noteImportance)
		 */
		//noteDate
		if (noteDate == null)
		{
			if (other.noteDate != null)
			{
				return false;
			}		
		} 
		else if (!noteDate.equals(other.noteDate))
		{
			return false;
		}
		
		//noteImportance
		if (noteImportance != other.noteImportance)
		{
			return false;
		}	
		
		//noteText
		if (noteText == null)
		{
			if (other.noteText != null)
			{
				return false;
			}	
		} 
		else if (!noteText.equals(other.noteText))
		{
			return false;
		}	
		return true;
	}	
	/*
	 * ___________________________________________
	 * �������������� ����� equals ��� ������ Note
	 */

}
