package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.InviteMapper;
import mapper.UserMapper;
import service.Constants;
import domain.IGroup;
import domain.IUser;

/**
 * Servlet implementation class InviteDeclineCtrl
 */
public class InviteDeclineCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviteDeclineCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(Constants.baseUrl + "/invite");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Logged in check
		if(session.getAttribute("user_id") == null) {
			
			response.sendRedirect(Constants.baseUrl + "/login");
			return;
		}
		
		// Member check
		int userId = Integer.parseInt(session.getAttribute("user_id").toString());
		IUser user = UserMapper.find(userId);
		IGroup userGroup = user.getGroup();
		if(userGroup != null) {
			
			response.sendRedirect(Constants.baseUrl + "/group");
			return;
		}
		
		// Assume it's always passed
		int inviteId = Integer.parseInt(request.getParameter("invite_id").toString());
		InviteMapper.delete(inviteId);
		
		response.sendRedirect(Constants.baseUrl + "/invite");
	}
}
