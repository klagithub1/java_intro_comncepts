package org.soenea.doitall.application.dispatcher;
import java.io.IOException;

import javax.servlet.ServletException;

import org.dsrg.soenea.domain.command.CommandException;

import org.soenea.doitall.domain.command.GroupRenameCommand;
public class GroupRename extends Dispatcher {

	@Override
	public void execute() throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			new GroupRenameCommand(this.myHelper).execute();
			/*The following should be modified*/
			forward("/WEB-INF/jsp/BrowsePeopleTV.jsp");
		} catch (final CommandException e) {
			throw new ServletException(e);
		}
	}

}
