package org.soenea.doitall.domain.command;
import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.soenea.doitall.domain.model.group.mapper.GroupInputMapper;
import org.soenea.doitall.domain.model.group.Group;

import org.soenea.doitall.domain.model.group.mapper.GroupOutputMapper;
public class GroupCreateCommand extends DomainCommand  {

	public GroupCreateCommand(Helper helper) {
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
			long id = (Long) helper.getAttribute("id");
			long version = (Long) helper.getAttribute("version");
			Group group = GroupInputMapper.find(id);
			helper.setRequestAttribute("group", group);
			group.setVersion(version);
			group.setName(group.getName());
			GroupOutputMapper.update(group);
			
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
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub
		
	}

}
