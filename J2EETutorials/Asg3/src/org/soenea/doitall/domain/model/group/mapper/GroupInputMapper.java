package org.soenea.doitall.domain.model.group.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.ObjectRemovedException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.IdentityMap;


import org.soenea.doitall.domain.model.group.Group;
import org.soenea.doitall.domain.model.group.tdg.GroupFinder;
  
public class GroupInputMapper {
	
	public static List<Group> findAll() throws SQLException{
		
		List<Group> Groups = new Vector<Group>();
		ResultSet rs = GroupFinder.findAll();
		
		while(rs.next())
			Groups.add(getGroup(rs));
		
		return Groups;
	}
	
	public static Group find(long id) throws SQLException, MapperException {
		
		try { 
			
			return IdentityMap.get(id, Group.class);
		}
		catch (DomainObjectNotFoundException e) { }
		catch (ObjectRemovedException e) { }
		
		ResultSet rs = GroupFinder.find(id); 
		if(!rs.next()) throw new MapperException("Group " + id + " does not exist.");
		 
		return getGroup(rs);
	}
	
	
	
	private static Group getGroup(ResultSet rs) throws SQLException {
		
	
		
		Group result = new Group(
			rs.getLong("id"),
			rs.getLong("version"),
			rs.getString("message")
			
		);
	
		return result;
	} 
}