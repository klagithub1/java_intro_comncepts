package org.soenea.doitall.application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.domain.command.CommandException;
import org.soenea.doitall.domain.command.PersonViewCommand;

public class PersonView extends Dispatcher
{

	@Override
	public void execute() throws ServletException, IOException 
	{
		try 
		{
			new PersonViewCommand(this.myHelper).execute();
			
			forward("/WEB-INF/jsp/ViewPersonTV.jsp");
			
		} 
		catch (final CommandException e) 
		{
			throw new ServletException(e);
		}
		
	}

}
