package com.domain;

public class group
{
	//Attributes
	
	private long id;
	private String groupname;
	
	//Methods
	
	public group()
	{
		this.id = 0;
		this.groupname = "";
		
	}
	
	public group(long id, String name)
	{
		this.id = id;
		this.groupname = name;
		
	}
	
	//Getters
	
	public long getId()
	{
		return this.id;
	}
	
	public String getGroupName()
	{
		return this.groupname;
	}
	
	public void setGroupName(String groupname)
	{
		this.groupname = groupname;
	}
	

}
