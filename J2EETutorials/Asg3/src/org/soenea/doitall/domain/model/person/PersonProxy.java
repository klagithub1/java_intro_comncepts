package org.soenea.doitall.domain.model.person;

import java.sql.SQLException;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;
import org.dsrg.soenea.domain.user.IUser;
import org.soenea.doitall.domain.model.person.mapper.PersonInputMapper;

public class PersonProxy extends DomainObjectProxy<Long, Person> implements IPerson {

	protected PersonProxy(Long id) {
		
		super(id);
	}

	@Override
	protected Person getFromMapper(Long id) throws MapperException, DomainObjectCreationException {
		
		try {
			
			return PersonInputMapper.find(id);
			
		} catch (final SQLException e) {
			
			throw new MapperException(e);
		}
	}

	@Override
	public String getFirstName() {
		
		return getInnerObject().getFirstName();
	}

	@Override
	public void setFirstName(String first) {
		
		getInnerObject().setFirstName(first);
	}

	@Override
	public String getLastName() {

		return getInnerObject().getLastName();
	}

	@Override
	public void setLastName(String last) {
		
		getInnerObject().setLastName(last);
	}

	@Override
	public IUser getUser() {

		return getInnerObject().getUser();
	}

	@Override
	public void setUser(IUser user) {
		
		getInnerObject().setUser(user);
	}
}
