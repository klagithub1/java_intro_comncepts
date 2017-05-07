package org.soenea.doitall.domain;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.soenea.doitall.services.datasource.PersonRDG;

public class BrowsePeopleTS
{
	
	public List<PersonHelper> execute()
	{
		List<PersonHelper> personList = new ArrayList<PersonHelper>();
		
		try {
			List<PersonRDG> people = PersonRDG.findAll();
			
			for(PersonRDG persRDG: people) 
			{
				PersonHelper person = new PersonHelper();
				person.setAge(persRDG.getAge());
				person.setName(persRDG.getName());
				person.setId(0);
				
				personList.add(person);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return personList;
	}
}
