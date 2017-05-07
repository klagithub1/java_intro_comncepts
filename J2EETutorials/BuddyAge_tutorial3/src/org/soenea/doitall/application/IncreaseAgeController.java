package org.soenea.doitall.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soenea.doitall.domain.IncreaseAgeTS;
import org.soenea.doitall.domain.PersonHelper;
import org.soenea.doitall.services.datasource.PersonRDG;

/*
 * Stuart Says:
 * I can't believe I forgot this again:
 * ssh -f sthiel@snape.encs.concordia.ca -L 3306:localhost:3306 -N
 */

/**
 * Servlet implementation class IncreaseAgeTS
 */
public class IncreaseAgeController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncreaseAgeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			String name = request.getParameter("name");
			PersonHelper person = new PersonHelper();
			person = new IncreaseAgeTS().execute(person, name);
			//person.setAge(person.getAge()+1);
			//person.update();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Increase " + name + "'s age</h2>");
				out.println(name + "'s age is now updated!<br/>");
				out.println("<a href='ViewPersonController?name="+name+"'>View " + name + " again</a><br/>");
				out.println("<a href='BrowsePeopleController'>Browse More People</a><br/>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
