package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.InviteMapper;
import mapper.UserMapper;
import domain.IGroup;
import domain.IInvite;
import domain.IUser;

import service.Constants;

/**
 * Servlet implementation class InviteAcceptCtrl
 */
public class InviteAcceptCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviteAcceptCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(Constants.baseUrl + "/invite");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		IInvite invite = InviteMapper.find(inviteId);
		
		if(invite == null) {
			
			response.getWriter().println("Invite row not found (ID " + inviteId + ")");
			return;
		}
		
		user.setGroup(invite.getGroup());
		UserMapper.update(user);
		
		InviteMapper.deleteAllTo(userId);
		
		response.sendRedirect(Constants.baseUrl + "/group/manage");
	}

}
