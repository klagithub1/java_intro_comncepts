package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.UserMapper;
import service.Constants;
import domain.IGroup;
import domain.IUser;

/**
 * Servlet implementation class GroupKickCtrl
 */
public class GroupKickCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupKickCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(Constants.baseUrl + "/group/manage");
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
		if(userGroup == null) {
			
			response.sendRedirect(Constants.baseUrl + "/group");
			return;
		}
		
		// Input check
		Object input = request.getParameter("user_id");
		if(input != null) {
			
			// Bai!
			int kickId = Integer.parseInt(input.toString());
			IUser kickedUser = UserMapper.find(kickId);
			kickedUser.setGroup(null);
			UserMapper.update(kickedUser);
		}
		
		response.sendRedirect(Constants.baseUrl + "/group/manage");
	}
}
