package org.soenea.doitall.domain.model.guild;

import org.dsrg.soenea.domain.DomainObject;

public class Guild extends DomainObject<Long> implements IGuild {

	private String name;
	
	protected Guild(long id, long version, String name) {
		
		super(id, version);
		this.name = name;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public void setName(String name) {
		
		this.name = name;
	}
}
