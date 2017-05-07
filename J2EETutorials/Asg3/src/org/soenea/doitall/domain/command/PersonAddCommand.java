package org.soenea.doitall.domain.command;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.mapper.PersonInputMapper;
import org.soenea.doitall.domain.model.person.mapper.PersonOutputMapper;

public class PersonAddCommand extends DomainCommand
{

	public PersonAddCommand(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws CommandException 
	{
		
		
	}

	@Override
	public void process() throws CommandException 
	{
		try {
			long id = (Long) helper.getAttribute("id");
			long version = (Long) helper.getAttribute("version");
			Person person = PersonInputMapper.find(id);
			helper.setRequestAttribute("person", person);
			person.setVersion(version);
			person.setFirstName(person.getFirstName());
			person.setLastName(person.getLastName());
			PersonOutputMapper.update(person);
			
			//OUTPUT HERE
			
			
			
		} catch (SQLException e) {
			throw new CommandException(e);
		} catch (DomainObjectNotFoundException e) {
			throw new CommandException(e);
		} catch (LostUpdateException e) {
			throw new CommandException(e);
		} catch (MapperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void tearDown() throws CommandError 
	{
		
		
	}

}
