package org.soenea.doitall.application.command;

import javax.servlet.http.HttpServletRequest;

import org.soenea.doitall.domain.model.person.mapper.PersonMapper;

public class BrowsePeople extends FrontCommand {
	private static final long serialVersionUID = 1L;

    public BrowsePeople() {
        super();
    }

	public String execute(HttpServletRequest request) {
		try {
			request.setAttribute("people", PersonMapper.findAll());
			return "/WEB-INF/jsp/BrowsePeopleTV.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
