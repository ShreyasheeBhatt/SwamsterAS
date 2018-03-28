import java.math.BigInteger;
import java.util.*;

public class Swimmer {
	private String lastName;
	private String firstName;
	private String team;
	private int age;
	private ArrayList<Race> races;
	private long id;
	
	public Swimmer(String last, String first, int numYrs, String teamName, ArrayList<Race> race) 
	{
		lastName = last;
		firstName = first;
		age = numYrs;
		team = teamName;
		races = race;
		id = 0;
	}
	
	/**
	 * Gets the last name of the swimmer. 
	 * @return last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Gets the first name of the swimmer. 
	 * @return first name
	 */
	public String getFirstName() 
	{
		return firstName;
	}
	
	/**
	 * Gets the age of the swimmer. 
	 * @return age in years
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Gets the team of the swimmer. 
	 * @return team name
	 */
	public String getTeam()
	{
		return team;
	}
	/**
	 * Gets the list of races the swimmer is swimming in this particular meet. 
	 * @return races
	 */
//	public ArrayList<Race> getRaces()
//	{
//		return races;
//	}
	
	/**
	 * 
	 * @return
	 */
	public Long getUniqueID()
	{
		char[] ident = new char[20];
		//id=----; id*=100;THINK ABOUT HOW TO CONVERT TEAM TO A NUMBER 
		ident[0]='1';
		ident[1]='0';
		if(age<=10) 
		{
			ident[2]='1';
			ident[3]='0';
		}
		else if(age==11 || age==12) 
		{
			ident[2]='1';
			ident[3]='1';
		}
		else if(age==13 || age==14) 
		{
			ident[2]='1';
			ident[3]='3';
		}
		else if(age>=15)
		{
			ident[2]='1';
			ident[3]='5';
		}
		
		char[] last = lastName.toLowerCase().toCharArray();
		char[] first = firstName.toLowerCase().toCharArray();
		String tempL = "";
		String tempF = "";
		int position = 4;
		
		/*
		 * last=bhatt
		 * first=shreya
		 */
		for(int n=0; n<4; n++)
		{
			tempL = String.valueOf(last[n]-'a'+1);
			if(tempL.length()%2 == 0)
			{
				for(int x=0; x<2; x++)
				{
					ident[position]=tempL.charAt(x);
					position++;
				}
			}
			else 
			{
				ident[position]='0';
				ident[position++] = tempL.charAt(0);
			}
		}
		for(int n=0; n<4; n++)
		{
			tempF = String.valueOf(first[n]-'a'+1);
			if(tempF.length()%2 == 0)
			{
				for(int x=0; x<2; x++)
				{
					ident[position]=tempF.charAt(x);
					position++;
				}
			}
			else 
			{
				ident[position]='0';
				ident[position++] = tempF.charAt(0);
			}
		}
		
		String finalID = new String (ident);
		System.out.println("In-Method Printed char[]: " + finalID);
		
		id = Long.parseLong(finalID.trim());
		
		return id;
	}
	
	public String getRaces() 
	{
	    String list = Arrays.toString(races.toArray()).replace(",", "").replace("[", "").replace("]", "");
	    return list.substring(1,list.length());
	}
	/**
	 * Converts Swimmer object to a string.
	 */
	@Override
	public String toString() {
		return (lastName + ", " + firstName + "\tAge: " + age + " years" + "\nRaces: \n" + getRaces());
	}
}
