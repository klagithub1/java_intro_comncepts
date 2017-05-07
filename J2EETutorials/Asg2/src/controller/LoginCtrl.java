package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Constants;

import mapper.UserMapper;

import domain.User;

/**
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_id") != null) {
			
			response.sendRedirect(Constants.baseUrl + "/group/browse");
			return;
		}
		
		String destination = "/login.jsp";
 
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_id") != null) {
			
			response.sendRedirect(Constants.baseUrl + "/group/browse");
			return;
		}
		
		String destination = "/login.jsp";
		String username = request.getParameter("username").toLowerCase();
		request.setAttribute("username", username);
		
		if(username != null && username.length() != 0) {
			
			User user = UserMapper.findByUsername(username);
			
			// Note: For demo purpose
			if(user != null) {
				
				if(user.getPassword().compareTo(request.getParameter("password")) == 0) {
				
					session.setAttribute("user_id", user.id);
					session.setAttribute("user_first_name", user.getFirstName());
					
					response.sendRedirect(Constants.baseUrl + "/group/browse");
					return;
				
				} else {
					
					request.setAttribute("msg_error", "Invalid username/password combination (Hint: It's '" + user.getPassword() + "')");
				}
				
			} else {
				
				request.setAttribute("msg_error", "Invalid username/password combination (Hint: There is no such user. Try admin/admin or username/password)");
			}
			
		} else {
			
			request.setAttribute("msg_error", "Please enter a username");
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
