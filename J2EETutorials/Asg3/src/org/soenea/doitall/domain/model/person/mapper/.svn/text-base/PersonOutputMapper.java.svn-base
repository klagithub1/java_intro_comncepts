package org.soenea.doitall.domain.model.person.mapper;

import java.sql.SQLException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.tdg.PersonTDG;
  
public class PersonOutputMapper  {
	
	public static void insert(Person p) throws LostUpdateException, SQLException {
		
		PersonTDG.insert(
			p.getId(), 
			p.getVersion(), 
			p.getFirstName(), 
			p.getLastName(), 
			p.getUser() == null ? 0 : p.getUser().getId()
		);
	}

	public static void update(Person p) throws LostUpdateException, SQLException {
		
		int count = PersonTDG.update(
			p.getId(), 
			p.getVersion(), 
			p.getFirstName(), 
			p.getLastName(), 
			p.getUser() == null ? 0 : p.getUser().getId()
		);
		
		if(count == 0)
			throw new LostUpdateException("PersonTDG: id " + p.getId() +  " version " + p.getVersion());
		
		p.setVersion(p.getVersion() + 1);
	}
	
	public static void delete(Person p) throws LostUpdateException, SQLException {
		
		int count = PersonTDG.delete(p.getId(), p.getVersion());
		
		if(count == 0)
			throw new LostUpdateException("PersonTDG: id " + p.getId() +  " version " + p.getVersion());
	}
}

