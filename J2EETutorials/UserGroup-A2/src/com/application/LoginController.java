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
public class LoginController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() 
    {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try{
			//Get request parameters
			//Refactor this ???
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User attemptedUser = UserMapper.findByUserName(username);
			
			//Check if that user exists
			if(attemptedUser == null)
			{
				throw new Error();
			}
			else
			{
				
					//Establish a session
					request.setAttribute("user", attemptedUser);
					request.getRequestDispatcher("WEB-INF/JSP/homepage.jsp").forward(request, response);
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}