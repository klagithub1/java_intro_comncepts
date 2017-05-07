package org.soenea.doitall.domain.command;
import java.sql.SQLException;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.helper.Helper;
import org.soenea.doitall.domain.model.group.mapper.GroupInputMapper;



public class GroupBrowseCommand extends DomainCommand {
	
	public GroupBrowseCommand(Helper helper) {

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
			helper.setRequestAttribute("groups", GroupInputMapper.findAll());
			
			
			//OUTPUT TABLE HERE 
			
			
			
			
		} catch (SQLException e) {
			throw new CommandException(e);
		}
	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub
		
	}



}
