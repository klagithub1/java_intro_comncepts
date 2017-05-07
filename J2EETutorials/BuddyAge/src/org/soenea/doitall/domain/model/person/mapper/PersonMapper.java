package org.soenea.doitall.domain.model.person.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.data.PersonTDG;

public class PersonMapper {
	public static List<Person> findAll() throws SQLException{
		List<Person> people = new Vector<Person>();
		ResultSet rs = PersonTDG.findAll();
		while(rs.next()) {
			people.add(getPerson(rs));
		}
		return people;
	}

	public static Person find(long id) throws SQLException, DomainObjectNotFoundException{
		ResultSet rs = PersonTDG.find(id);
		if(rs.next()) {
			return getPerson(rs);
		} else {
			throw new DomainObjectNotFoundException("Cannot find a person with id " + id);
		}
	}

	private static Person getPerson(ResultSet rs) throws SQLException {
		Person result = new Person(
				rs.getLong("p.id"),
				rs.getInt("p.version"),
				rs.getString("p.name"),
				rs.getInt("p.age")
				);
		return result;
	}
	
	public static void insert(Person p) throws LostUpdateException, SQLException {
		PersonTDG.insert(p.getId(), p.getVersion(), p.getName(), p.getAge());
	}

	public static void update(Person p) throws LostUpdateException, SQLException {
		int count = PersonTDG.update(p.getId(), p.getVersion(), p.getAge());
		if(count == 0) {
			throw new LostUpdateException("It appears that someone else may already have changed this person.");
		}
		p.setVersion(p.getVersion()+1);
	}
	
	public static void delete(Person p) throws LostUpdateException, SQLException {
		int count = PersonTDG.delete(p.getId(), p.getVersion());
		if(count == 0) {
			throw new LostUpdateException("It appears that someone else may already have changed this person.");
		}
	}
}
