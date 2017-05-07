package org.soenea.doitall.domain.command;
import java.sql.SQLException;



import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.user.User;
import org.dsrg.soenea.domain.user.mapper.UserInputMapper;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.mapper.PersonInputMapper;
import org.soenea.doitall.domain.model.person.mapper.PersonOutputMapper;


public class PersonDeleteCommand  extends DomainCommand {

	public PersonDeleteCommand(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws CommandException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process() throws CommandException {
		// TODO Auto-generated method stub
		
		try {
		long id = (Long) helper.getAttribute("user_id");
		long version = (Long) helper.getAttribute("version");
		
		User user = UserInputMapper.find(id);
		Person person;
		
		person = PersonInputMapper.find(user.getId());
		
		helper.setRequestAttribute("person", person);
		person.setVersion(version);
		person.setFirstName(person.getFirstName());
		person.setLastName(person.getLastName());
		
		//check if group is null then do something...
		
		PersonOutputMapper.delete(person);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MapperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//OUTPUT HERE
		
	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub
		
	}

}
