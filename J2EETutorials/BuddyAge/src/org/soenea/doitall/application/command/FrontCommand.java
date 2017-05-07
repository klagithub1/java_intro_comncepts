package org.soenea.doitall.application.command;

import javax.servlet.http.HttpServletRequest;

public abstract class FrontCommand {
	public abstract String execute(HttpServletRequest req);
}
