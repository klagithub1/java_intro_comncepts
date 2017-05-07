package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.GroupMapper;
import com.domain.group;

/**
 * Servlet implementation class AddUserController
 */
//@WebServlet("/AddUserController")
public class GroupRemoveController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupRemoveController() 
    {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try{
			//Get request parameters
			String id = request.getParameter("id");
			
			group toDelete = GroupMapper.find(Long.parseLong(id));
			
			//Remove the user
			GroupMapper.delete(toDelete);
			
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Deletion of a Group</h2>");
			out.println(" The group has been successfully deleted !<br/>");
			out.println("<a href='removegroup.html'>Go Back</a>");
			
		}
		catch (Exception e)
		{
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Deletion of a Group</h2>");
			out.println("Oops! There was an error while trying to delete the group.");
			out.println("<a href='removegroup.html'>Go Back</a>");
			e.printStackTrace();
		}
	}
}