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
public class GroupEditController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupEditController() 
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
			
			Long gid = new Long(id);
			group newGroup = GroupMapper.find(gid);
				
			newGroup.setGroupName(groupname);
			
			GroupMapper.update(newGroup);
				
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Update of a  group.</h2>");
			out.println(groupname +" is now updated !<br/>");
			out.println("<a href='updategroup.html'>Go Back</a>");

		}
		catch (Exception e)
		{
			//Another VIew Template
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Error in updating of a group.</h2>");
			out.println("Oops! Something went wrong!");
			out.println("<a href='updategroup.html'>Go Back</a>");
			e.printStackTrace();
		}
	}
}