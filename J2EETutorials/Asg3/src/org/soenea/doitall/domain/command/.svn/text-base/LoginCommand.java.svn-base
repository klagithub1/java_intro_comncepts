package org.soenea.doitall.domain.command;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.user.mapper.UserInputMapper;

public class LoginCommand extends Command {

	public LoginCommand(Helper helper) {
		
		super(helper);
	}

	@Override
	public void setUp() throws CommandException { }

	@Override
	public void process() throws CommandException {

		// Input fetch
		String username = helper.getString("username"); 
		String password = helper.getString("password"); 

		// Existence check
		if(username == null || password == null)
			throw new CommandException("Missing field information."); 
		
		// Fixing
		username = username.trim();
		password = password.trim();
		
		// Required check
		if(username.equals("")) {
			
			getNotifications().add("Username cannot be left blank."); 
			throw new CommandException("Username cannot be left blank.");
		}
		
		// Check and create user session
		try { 
			
			helper.setSessionAttribute("user", UserInputMapper.find(username, password)); 
			
		} catch (SQLException e) { 

			e.printStackTrace(); 
			throw new CommandException(e); 
			
		} catch (MapperException e) {
			
			getNotifications().add("Invalid username/password combination."); 
			throw new CommandException("Invalid username/password combination."); 
		}
	}

	@Override
	public void tearDown() throws CommandError { }
}
