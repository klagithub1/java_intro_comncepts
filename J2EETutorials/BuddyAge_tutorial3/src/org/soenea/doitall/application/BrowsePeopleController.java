package org.soenea.doitall.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soenea.doitall.domain.BrowsePeopleTS;
import org.soenea.doitall.domain.PersonHelper;
import org.soenea.doitall.services.datasource.PersonRDG;

/**
 * Servlet implementation class BrowsePeopleTS
 */
public class BrowsePeopleController extends SampleHttpServlet 
{
	private static final long serialVersionUID = 1L;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowsePeopleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<PersonHelper> people = new ArrayList<PersonHelper>();
			people = new BrowsePeopleTS().execute();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Browse People</h2>");
			for(PersonHelper person: people) 
			{
				out.println("<a href='ViewPersonController?name=" + person.getName() + "'>" + person.getName() + "</a><br/>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void execute() 
	{
		// TODO Auto-generated method stub
		
	}
}
