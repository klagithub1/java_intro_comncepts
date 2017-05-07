package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Group;
import domain.GroupProxy;
import domain.IUser;

import mapper.GroupMapper;
import mapper.UserMapper;

import service.Constants;

/**
 * Servlet implementation class GroupCreateCtrl
 */
public class GroupCreateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupCreateCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_id") == null) {
			
			response.sendRedirect(Constants.baseUrl + "/login");
			return;
		}
		
		String destination = "/group_create.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_id") == null) {
			
			response.sendRedirect(Constants.baseUrl + "/login");
			return;
		}
		
		String groupName = request.getParameter("name");
		
		if(groupName != null) {
			
			groupName = groupName.trim();
			
			if(groupName.length() != 0) {
				
				int groupId = GroupMapper.insert(new Group(groupName));
				
				IUser user = UserMapper.find(Integer.parseInt(session.getAttribute("user_id").toString()));
				user.setGroup(new GroupProxy(groupId));
				UserMapper.update(user);
				
				response.sendRedirect(Constants.baseUrl + "/group/manage");
				return;
				
			} else {
				
				request.setAttribute("msg_error", "Name field must be filled");
			}
		
		} else {
			
			request.setAttribute("msg_error", "Missing parameters.");
		}
		
		String destination = "/group_create.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
