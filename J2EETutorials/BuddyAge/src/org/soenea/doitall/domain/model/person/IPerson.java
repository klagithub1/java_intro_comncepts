package org.soenea.doitall.domain.model.person;

public interface IPerson 
{
	public long getID();
	public int getVersion();
	public String getName();
	public int getAge();
	public IPerson getBuddy();
}
