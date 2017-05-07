package org.soenea.doitall.application.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.soenea.doitall.domain.model.person.Person;
import org.soenea.doitall.domain.model.person.mapper.PersonMapper;

public class IncreaseAge extends FrontCommand {
	private static final long serialVersionUID = 1L;

    public IncreaseAge() {
        super();
    }

	public String execute(HttpServletRequest request) {
		long id = 0;
		Person person = null;
		try {

			id = Long.parseLong(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			person = PersonMapper.find(id);
			request.setAttribute("person", person);
			
			person.setVersion(version);
			person.setAge(person.getAge()+1);
			
			PersonMapper.update(person);
			
			DbRegistry.getDbConnection().createStatement().execute("COMMIT");
			
			return "/WEB-INF/jsp/ViewPersonTV.jsp";
		} catch (LostUpdateException e) {
			try {
				person = PersonMapper.find(id);
			} catch (Exception e1) {
				// Shouldn't ever happen if we already got this far.
				e1.printStackTrace();
			}
			request.setAttribute("person", person);
			request.setAttribute("warning", e.getMessage());
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
