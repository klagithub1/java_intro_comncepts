package org.soenea.doitall.application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.domain.command.CommandException;
import org.soenea.doitall.domain.command.PersonAddCommand;
import org.soenea.doitall.domain.command.PersonViewCommand;

//This is supposed to be an ADMINISTRATOR FEATURE
public class PersonAdd extends Dispatcher
{

	@Override
	public void execute() throws ServletException, IOException 
	{
		try 
		{
			new PersonAddCommand(this.myHelper).execute();
			
			forward("/WEB-INF/jsp/AddPersonTV.jsp");
			
		} 
		catch (final CommandException e) 
		{
			throw new ServletException(e);
		}
		
	}

}
