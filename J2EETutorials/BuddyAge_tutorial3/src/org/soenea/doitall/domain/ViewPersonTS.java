package org.soenea.doitall.domain;

import java.io.PrintWriter;

import org.soenea.doitall.services.datasource.PersonRDG;

public class ViewPersonTS
{
	
	public PersonHelper execute(PersonHelper person, String name)
	{
		
		try {
			
			PersonRDG pers = PersonRDG.find(name);

				if(pers != null) 
				{
					person.setAge(pers.getAge());
					person.setName(pers.getName());
					person.setId(0);
				}
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return person;
	}
}
