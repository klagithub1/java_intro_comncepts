package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.UserMapper;
import service.Constants;
import domain.IUser;
import domain.User;

/**
 * Servlet implementation class UserCreateCtrl
 */
public class UserCreateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Logged on check
		if(session.getAttribute("user_id") == null) {
			
			response.sendRedirect(Constants.baseUrl + "/login");
			return;
		}
		
		// Admin check
		int userId = Integer.parseInt(session.getAttribute("user_id").toString());
		IUser user = UserMapper.find(userId);
		if(!user.isAdmin()) {
			
			response.sendRedirect(Constants.baseUrl + "/group");
			return;
		}
		
		String destination = "/user_create.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		// Logged on check
		if(session.getAttribute("user_id") == null) {
			
			response.sendRedirect(Constants.baseUrl + "/login");
			return;
		}
		
		// Admin check
		int userId = Integer.parseInt(session.getAttribute("user_id").toString());
		IUser user = UserMapper.find(userId);
		if(!user.isAdmin()) {
			
			response.sendRedirect(Constants.baseUrl + "/group");
			return;
		}
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		boolean isAdmin = request.getParameter("admin") != null;
		
		String groupIdInput = request.getParameter("group_id");
		int groupId = (groupIdInput != null) ?
			Integer.parseInt(groupIdInput.toString()) :
			0;
		
		if(username != null && password != null && firstName != null && lastName != null) {
			
			// Formatting
			username = username.trim().toLowerCase();
			firstName = firstName.trim();
			lastName = lastName.trim();
			
			if(username.length() != 0 && firstName.length() != 0 && lastName.length() != 0) {
				
				User newUser = new User(username, password, firstName, lastName, isAdmin, groupId);
				UserMapper.insert(newUser);
				
				response.sendRedirect(Constants.baseUrl + "/admin/user/create");
				return;
				
			} else {
				
				request.setAttribute("username", username);
				request.setAttribute("first_name", firstName);
				request.setAttribute("last_name", lastName);
				
				request.setAttribute("msg_error", "All required fields must be filled");
			}
		
		} else {
			
			request.setAttribute("msg_error", "Missing parameters.");
		}
		
		String destination = "/user_create.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
