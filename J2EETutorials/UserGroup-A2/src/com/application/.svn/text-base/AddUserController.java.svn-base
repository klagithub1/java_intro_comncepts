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
public class AddUserController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() 
    {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try{
			//Get request parameters
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String admin = request.getParameter("admin");
			
			User newUser = new User(Long.parseLong(id), username, password, firstName, lastName, Boolean.parseBoolean(admin));
			
			UserMapper.insert(newUser);
				
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Creation of a new user.</h2>");
			out.println(firstName + " "+lastName+" is now created as a new user!<br/>");
			out.println("<a href='adduser.html'>Go Back</a>");

		}
		catch (Exception e)
		{
			//Another VIew Template
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Error in creation of a new user.</h2>");
			out.println("Oops! Something went wrong! Probably te user you are trying to create has already been created.");
			out.println("<a href='adduser.html'>Go Back</a>");
			e.printStackTrace();
		}
	}
}