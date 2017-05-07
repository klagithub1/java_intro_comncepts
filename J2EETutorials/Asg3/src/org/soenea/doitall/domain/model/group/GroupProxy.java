package org.soenea.doitall.domain.model.group;

import java.sql.SQLException;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;
import org.soenea.doitall.domain.model.group.IGroup;
import org.soenea.doitall.domain.model.group.Group;
import org.soenea.doitall.domain.model.group.mapper.GroupInputMapper;





public class GroupProxy extends DomainObjectProxy<Long, Group> implements IGroup {

	
	
	public GroupProxy(long id) {
		
		super(id);
		
	}
	
	public Group getFromMapper(Long id) throws MapperException, DomainObjectCreationException {
		
		try {
			
			return GroupInputMapper.find(id);
			
		} catch (final SQLException e) {
			
			throw new MapperException(e);
		}
	}
	
	@Override
	public String getName() {
		return getInnerObject().getName();
	}

	@Override
	public void setName(String name) {
		getInnerObject().setName(name);
	}

	@Override
	public Long getId() {
		
		return getInnerObject().getId();
	}
}
