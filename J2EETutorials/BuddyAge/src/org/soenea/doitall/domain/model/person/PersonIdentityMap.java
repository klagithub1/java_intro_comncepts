package org.soenea.doitall.domain.model.person;

import java.util.Map;

public class PersonIdentityMap
{
	private Map<String, Person> knownPersons;
	
	public void put(long id, Person value)
	{
		knownPersons.put(String.valueOf(id), value);
	}
	
	public long get(long id)
	{
		return id;
	}
}
