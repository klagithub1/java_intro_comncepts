package org.soenea.doitall.domain;

import java.io.PrintWriter;

import org.soenea.doitall.services.datasource.PersonRDG;

public class IncreaseAgeTS
{
	
	public PersonHelper execute(PersonHelper person, String name)
	{
		
		try {
			PersonRDG persRDG = PersonRDG.find(name);
			person.setName(persRDG.getName());
			person.setAge(persRDG.getAge()+1);
			person.setId(0);
			persRDG.setAge(person.getAge());
			persRDG.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return person;
	}
}
