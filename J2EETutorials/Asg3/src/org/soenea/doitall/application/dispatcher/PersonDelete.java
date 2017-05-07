package org.soenea.doitall.application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.domain.command.CommandException;
import org.soenea.doitall.domain.command.PersonDeleteCommand;
import org.soenea.doitall.domain.command.PersonViewCommand;

public class PersonDelete extends Dispatcher
{

	@Override
	public void execute() throws ServletException, IOException 
	{
		try 
		{
			new PersonDeleteCommand(this.myHelper).execute();
			
			forward("/WEB-INF/jsp/DeletePersonTV.jsp");
			
		} 
		catch (final CommandException e) 
		{
			throw new ServletException(e);
		}
		
	}

}
