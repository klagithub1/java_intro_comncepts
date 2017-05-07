package com.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.domain.GroupMapper;

import com.domain.group;

/**
 * Servlet implementation class GroupBrowseController
 */
//@WebServlet("/GroupCreateController")
public class GroupBrowseController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupBrowseController() 
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
			Long gid = null;
			group g = null;
			
			if(id!=null){
			 gid = new Long(id);
			 g =  GroupMapper.find(gid);
			}else if (groupname!=null){
				 g =  GroupMapper.findByGroupName(groupname);
			}
				
				
		
			
			
			
		
			
				
			//Print Response - View Template on its own
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Browse  group.</h2>");
			out.println("<p>here are the results</p>"+ g.getGroupName() + "<br/>");
			out.println("<a href='browsegroup.html'>Go Back</a>");

		}
		catch (Exception e)
		{
			//Another VIew Template
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>Error in browsing groups.</h2>");
			out.println("Oops! Something went wrong!Maybe the group name you are trying to find does not exist ! ");
			out.println("<a href='browsegroup.html'>Go Back</a>");
			e.printStackTrace();
		}
	}
}