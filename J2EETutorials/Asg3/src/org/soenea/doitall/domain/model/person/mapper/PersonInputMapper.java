package org.soenea.doitall.domain.model.person.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.ObjectRemovedException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.IdentityMap;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.domain.user.UserProxy;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.tdg.PersonFinder;
  
public class PersonInputMapper {
	
	public static List<Person> findAll() throws SQLException{
		
		List<Person> Persons = new Vector<Person>();
		ResultSet rs = PersonFinder.findAll();
		
		while(rs.next())
			Persons.add(getPerson(rs));
		
		return Persons;
	}
	
	public static Person find(long id) throws SQLException, MapperException {
		
		try { 
			
			return IdentityMap.get(id, Person.class);
		}
		catch (DomainObjectNotFoundException e) { }
		catch (ObjectRemovedException e) { }
		
		ResultSet rs = PersonFinder.find(id); 
		if(!rs.next()) throw new MapperException("Person " + id + " does not exist.");
		 
		return getPerson(rs);
	}
	
	private static Person getPerson(ResultSet rs) throws SQLException {
		
		long userId = rs.getLong("user_id");
		IUser user = (userId != 0) ?
			new UserProxy(userId) :
			null;
		
		Person result = new Person(
			rs.getLong("id"),
			rs.getLong("version"),
			rs.getString("first_name"),
			rs.getString("last_name"),
			user
		);
	
		return result;
	} 
}