package org.soenea.doitall.domain;

public class PersonHelper 
{
	private int personID;
	private String name;
	private int age;
	
	public PersonHelper(int personID, String name, int age)
	{
		this.personID = personID;
		this.age = age;
		this.name = name;
	}
	
	public PersonHelper() 
	{
		//Default
	}

	public int getId()
	{
		return this.personID;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setId(int id)
	{
		this.personID = id;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setName(String value)
	{
		this.name = value;
	}
}
