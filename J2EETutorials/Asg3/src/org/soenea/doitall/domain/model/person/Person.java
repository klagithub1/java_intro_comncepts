package org.soenea.doitall.domain.model.person;

import org.dsrg.soenea.domain.DomainObject;
import org.dsrg.soenea.domain.user.IUser;

public class Person extends DomainObject<Long> implements IPerson {

	private String first;
	private String last;
	private IUser user;
	
	public Person(long id, long version, String first, String last, IUser user) {
		
		super(id, version);
		this.first = first;
		this.last = last;
		this.user = user;
	}	
	
	@Override
	public String getFirstName() {
		
		return this.first;
	}

	@Override
	public void setFirstName(String first) {
		
		this.first = first;
	}

	@Override
	public String getLastName() {
		
		return this.last;
	}

	@Override
	public void setLastName(String last) {
		
		this.last = last;
	}

	@Override
	public IUser getUser() {

		return this.user;
	}

	@Override
	public void setUser(IUser user) {
		
		this.user = user;
	}

}
