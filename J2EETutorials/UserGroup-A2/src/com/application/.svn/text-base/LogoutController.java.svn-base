package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends SampleHttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getSession().invalidate();
		PrintWriter out = response.getWriter();
		response.sendRedirect("index.html");
	}
}
