package org.soenea.doitall.domain.model.group;

import org.dsrg.soenea.domain.DomainObject;
import org.soenea.doitall.domain.model.group.IGroup;

public class Group extends DomainObject<Long> implements IGroup {
	
	
	public final long id;
	private String name;
	
	
	public Group(long id, long version, String name) {
		
		super(id,version);
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}
}
