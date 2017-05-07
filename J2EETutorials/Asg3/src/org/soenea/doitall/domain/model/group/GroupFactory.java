package org.soenea.doitall.domain.model.group;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.uow.UoW;
import org.soenea.doitall.domain.model.guild.IGuild;
import org.soenea.doitall.domain.model.group.tdg.GroupTDG;

public class GroupFactory {

	public static final long FIRST_VERSION = 1;
	
	public static Group createNew(String name) throws SQLException, MapperException {
		
		Group result = new Group(
			GroupTDG.getMaxId(),
			FIRST_VERSION,
			name
		
		);
		
		UoW.getCurrent().registerNew(result);
		
		return result;
	}
	public static Group createClean(long id, long version, String name) throws SQLException {
		
		Group result = new Group(
			id,
			version,
			name
		);
		
		UoW.getCurrent().registerClean(result);
		
		return result;
	}
		
}
