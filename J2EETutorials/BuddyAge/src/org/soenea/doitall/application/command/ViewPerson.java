package org.soenea.doitall.application.command;

import javax.servlet.http.HttpServletRequest;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.mapper.PersonMapper;

public class ViewPerson extends FrontCommand {
	private static final long serialVersionUID = 1L;

    public ViewPerson() {
        super();
    }

	public String execute(HttpServletRequest request) {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			Person person = PersonMapper.find(id);
			request.setAttribute("person", person);

			return "/WEB-INF/jsp/ViewPersonTV.jsp";
		} catch (DomainObjectNotFoundException e) {
			request.setAttribute("warning", e.getMessage());
			return "/WEB-INF/jsp/ViewPersonTV.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
