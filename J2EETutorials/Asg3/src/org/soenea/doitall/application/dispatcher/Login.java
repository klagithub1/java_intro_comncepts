package org.soenea.doitall.application.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;

import org.soenea.doitall.domain.command.LoginCommand;

public class Login extends Dispatcher {

	@Override
	public void execute() throws ServletException, IOException {

		try {
			
			new LoginCommand(myHelper).execute(); 
			relativeRedirect("/group/browse");
			
		} catch (Exception e) {
			
			forward("/login.jsp");
		} 
	}
}
