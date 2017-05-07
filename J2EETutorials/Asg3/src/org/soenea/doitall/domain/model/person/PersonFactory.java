package org.soenea.doitall.domain.model.person;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.uow.UoW;
import org.soenea.doitall.domain.model.person.tdg.PersonTDG;

public class PersonFactory {

	public static final long FIRST_VERSION = 1;
	
	public static Person createNew(String first, String last, IUser user) throws SQLException, MapperException {
		
		Person p = new Person(
			PersonTDG.getMaxId(),
			FIRST_VERSION,
			first,
			last,
			user
		);
		
		UoW.getCurrent().registerNew(p);
		
		return p;
	}
	public static Person createClean(long id, long version, String first, String last, IUser user) throws SQLException {
		
		Person p = new Person(
			id,
			version,
			first,
			last,
			user
		);
			
		UoW.getCurrent().registerClean(p);
			
		return p;
	}
		
}
