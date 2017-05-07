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
 * Servlet implementation class GroupCreateController
 */
//@WebServlet("/GroupCreateController")
public class GroupCreateController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupCreateController() 
    {
        super();
    }

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try{
			//Get request parameters
			String id = request.getParameter("id");
			String groupname = request.getParameter("groupname");
			
			group newGroup = new group(Long.parseLong(id), groupname);
			
			GroupMapper.insert(newGroup);
				
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Creation of a new group.</h2>");
			out.println(groupname +" is now created as a new group!<br/>");
			out.println("<a href='addgroup.html'>Go Back</a>");

		}
		catch (Exception e)
		{
			//Another VIew Template
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Error in creation of a new group.</h2>");
			out.println("Oops! Something went wrong! Probably the group you are trying to create has already been created.");
			out.println("<a href='addgroup.html'>Go Back</a>");
			e.printStackTrace();
		}
	}
}