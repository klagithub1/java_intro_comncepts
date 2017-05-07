package org.soenea.doitall.domain.model.person;

public class PersonProxy implements IPerson
{

	private long id;
	
	@Override
	public long getID() 
	{
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public int getVersion() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAge() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPerson getBuddy() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public Person getRealPerson()
	{
		return null;
	}

}
