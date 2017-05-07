package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.IGroup;
import domain.IUser;

import mapper.UserMapper;

import service.Constants;

/**
 * Servlet implementation class GroupManageCtrl
 */
public class GroupManageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupManageCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		// Fetch members
		List<IUser> members = UserMapper.findByGroupId(userGroup.getId());
		String table_row_members = null;
		for(int i = 0; i < members.size(); ++i) {
			
			IUser member = members.get(i);
			table_row_members += "<tr><td>" + member.getUsername()
				+ "</td><td>" + member.getFirstName() + " " + member.getLastName()
				+ "</td><td><button onclick=\"document.getElementById('kick_id').value = " + member.getId() + "; submit()\">Kick!</button></td></tr>";
		}
		
		// Prepare view data
		request.setAttribute("group_name", userGroup.getName());
		request.setAttribute("table_rows_members", table_row_members);
		
		String destination = "/group_manage.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
