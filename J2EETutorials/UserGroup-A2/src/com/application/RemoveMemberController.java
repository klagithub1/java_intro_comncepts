package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.domain.User;
import com.domain.UserMapper;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/AddUserController")
public class RemoveMemberController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveMemberController() 
    {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try{
			//Get request parameters
			String id = request.getParameter("id");
			
			User toDelete = UserMapper.find(Long.parseLong(id));
			
			//Remove the user
			UserMapper.delete(toDelete);
			
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Deletion of an User</h2>");
			out.println(" The user has been successfully deleted !<br/>");
			out.println("<a href='removeuser.html'>Go Back</a>");
			
		}
		catch (Exception e)
		{
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Deletion of an User</h2>");
			out.println("Oops! There was an error while trying to delete the user.");
			out.println("<a href='removeuser.html'>Go Back</a>");
			e.printStackTrace();
		}
	}
}