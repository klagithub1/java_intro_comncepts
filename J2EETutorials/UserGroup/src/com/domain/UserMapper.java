package com.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import com.technicalservices.UserTDG;;

public class UserMapper 
{
	public static List<User> findAll() throws SQLException
	{
		List<User> users = new Vector<User>();
		ResultSet rs = UserTDG.findAll();
		while(rs.next()) 
		{
			users.add(getUser(rs));
		}
		return users;
	}

	public static User find(long id) throws SQLException, DomainObjectNotFoundException
	{
		ResultSet rs = UserTDG.find(id);
		if(rs.next()) 
		{
			return getUser(rs);
		} 
		else 
		{
			throw new DomainObjectNotFoundException("Cannot find a person with id " + id);
		}
	}
	
	public static User findByUserName(String username) throws SQLException, DomainObjectNotFoundException
	{
		ResultSet rs = UserTDG.findByUserName(username);
		
		if(rs.next()) 
		{
			return getUser(rs);
		} 
		else 
		{
			throw new DomainObjectNotFoundException("Cannot find a person with username " + username);
		}
	}

	private static User getUser(ResultSet rs) throws SQLException 
	{
		User result = new User(
				rs.getLong("p.id"),
				rs.getString("p.username"),
				rs.getString("p.password"),
				rs.getString("p.first_name"),
				rs.getString("p.last_name"),
				rs.getBoolean("p.admin")
				);
		return result;
	}
	
	public static void insert(User p) throws LostUpdateException, SQLException 
	{
		UserTDG.insert(p.getId(), p.getUsername(), p.getPassword(), p.getFirstName(), p.getLastName(), p.isAdmin());
	}

	public static void update(User p) throws LostUpdateException, SQLException 
	{
		int count = UserTDG.update(p.getId(), p.getUsername(), p.getPassword(), p.getFirstName(), p.getFirstName(), p.isAdmin());
		if(count == 0) 
		{
			throw new LostUpdateException("The user has already been updated with the changes requested !!");
		}
	}
	
	public static void delete(User p) throws LostUpdateException, SQLException 
	{
		int count = UserTDG.delete(p.getId());
		if(count == 0) 
		{
			throw new LostUpdateException("This user has already been deleted from the database !");
		}
	}
}