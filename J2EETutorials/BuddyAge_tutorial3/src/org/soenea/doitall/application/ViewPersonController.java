package org.soenea.doitall.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.soenea.doitall.domain.PersonHelper;
import org.soenea.doitall.services.datasource.PersonRDG;

/**
 * Servlet implementation class ViewPersonTS
 */
public class ViewPersonController extends SampleHttpServlet 
{
	private static final long serialVersionUID = 1L;
	//public String test = "George";

    public ViewPersonController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			
			String name = request.getParameter("name");
			//PersonRDG person = PersonRDG.find(name);
			PersonHelper person = new PersonHelper();
			person = new org.soenea.doitall.domain.ViewPersonTS().execute(person, name);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>View " + name + "</h2>");
			if(person != null) 
			{
				out.println(name + " is " + person.getAge() + " years old.<br/><a href='IncreaseAgeController?name=" + name + "'>Make " + name + " older!</a><br/>");			
			}
			out.println("<a href='BrowsePeopleController'>Browse More People</a><br/>");
			
			}
		catch (Exception e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	
//	
//		private static Hashtable<String, Long> IDs = new Hashtable<String, Long>();
//		
//		public synchronized long getId(String table, String field) throws SQLException
//		{
//			Long max_id = IDs.get(table+"."+field);
//			if (max_id == null)
//			{
//				ResultSet rs = DbRegistry.getDbConnection().createStatement().executeQuery(
//						"SELECT max(" + field + ") AS maximum FROM " +
//						DbRegistry.getTablePrefix() + table);
//				max_id = rs.next() ? rs.getLong("maximum") : 1;
//				rs.close();
//			}
//			IDs.put(table+"."+field, ++max_id);
//			return max_id;
//		}
//	

}
