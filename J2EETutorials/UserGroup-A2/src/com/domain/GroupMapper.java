package com.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import com.technicalservices.GroupTDG;

public class GroupMapper
{
	public static List<group> findAll() throws SQLException
	{
		List<group> groups = new Vector<group>();
		ResultSet rs = GroupTDG.findAll();
		while(rs.next()) 
		{
			groups.add(getGroup(rs));
		}
		return groups;
	}

	public static group find(long id) throws SQLException, DomainObjectNotFoundException
	{
		ResultSet rs = GroupTDG.find(id);
		if(rs.next()) 
		{
			return getGroup(rs);
		} 
		else 
		{
			throw new DomainObjectNotFoundException("Cannot find a group with id " + id);
		}
	}
	
	public static group findByGroupName(String groupname) throws SQLException, DomainObjectNotFoundException
	{
		ResultSet rs = GroupTDG.findByGroupName(groupname);
		
		if(rs.next()) 
		{
			return getGroup(rs);
		} 
		else 
		{
			throw new DomainObjectNotFoundException("Cannot find a group with name " + groupname);
		}
	}

	private static group getGroup(ResultSet rs) throws SQLException 
	{
		group result = new group(
				rs.getLong("p.id"),
				rs.getString("p.name")
				
				);
		return result;
	}
	
	public static void insert(group p) throws LostUpdateException, SQLException 
	{
		GroupTDG.insert(p.getId(), p.getGroupName());
	}

	public static void update(group p) throws LostUpdateException, SQLException 
	{
		int count = GroupTDG.update(p.getId(), p.getGroupName());
		if(count == 0) 
		{
			throw new LostUpdateException("The group has already been updated with the changes requested !!");
		}
	}
	
	public static void delete(group p) throws LostUpdateException, SQLException 
	{
		int count = GroupTDG.delete(p.getId());
		if(count == 0) 
		{
			throw new LostUpdateException("This group has already been deleted from the database !");
		}
	}
}