package org.soenea.doitall.domain.model.guild;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;

public class GuildProxy extends DomainObjectProxy<Long, Guild> implements IGuild {

	public GuildProxy(Long id) {
		super(id);
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
	protected Guild getFromMapper(Long id) throws MapperException,
			DomainObjectCreationException {
		
		/*try {
			final Person person = PersonInputMapper.find(id);
			return person;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}*/
		
		return null;
	}

	@Override
	public String toString() {
		return getInnerObject().toString();
	}
}