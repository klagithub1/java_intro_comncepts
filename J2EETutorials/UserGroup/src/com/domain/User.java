package com.domain;

public class User 
{
	//Attributes
	
	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean admin;
	
	//Methods
	
	public User()
	{
		this.id = 0;
		this.username = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.admin = false;
	}
	
	public User(long id, String username, String password, String firstName, String lastName, boolean admin)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = admin;
	}
	
	//Getters
	
	public long getId()
	{
		return this.id;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public boolean isAdmin()
	{
		return this.admin;
	}
	
	//Setters
	
	public void setUsername(String arg)
	{
		this.username = arg;
	}
	
	public void setId(int arg)
	{
		if(id <0)
		{
			throw new Error();
		}
		else
		{
			this.id = arg;
		}
	}
	
	public void setPassword(String arg)
	{
		this.password = arg;
	}
	
	public void setFirstName(String arg)
	{
		this.firstName = arg;
	}
	
	public void setLastName(String arg)
	{
		this.lastName = arg;
	}
	
	public void setAdmin(boolean arg)
	{
		this.admin = arg;
	}
}
