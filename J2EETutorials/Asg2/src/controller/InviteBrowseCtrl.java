package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.InviteMapper;
import mapper.UserMapper;
import service.Constants;
import domain.IGroup;
import domain.IInvite;
import domain.IUser;

/**
 * Servlet implementation class InviteBrowseCtrl
 */
public class InviteBrowseCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviteBrowseCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		if(userGroup != null) {
			
			response.sendRedirect(Constants.baseUrl + "/group");
			return;
		}
		
		// Fetch guildless people
		/*List<IUser> guildlessUsers = UserMapper.findAllAlone();
		String table_rows = null;
		for(int i = 0; i < guildlessUsers.size(); ++i) {
			
			IUser member = guildlessUsers.get(i);
			table_rows += "<tr><td>" + member.getUsername()
				+ "</td><td>" + member.getFirstName() + " " + member.getLastName()
				+ "</td><td><a href=" + Constants.baseUrl + "invite onclick=\"document.getElementById('invite_id').value = " + member.getId() + "; submit()\">Kick!</button></td></tr>";
		}
		
		request.setAttribute("table_rows", table_rows);*/
		
		// Fetch invites
		List<IInvite> invites = InviteMapper.findAllTo(userId);
		String table_rows = null;
		for(int i = 0; i < invites.size(); ++i) {
			
			IInvite invite = invites.get(i);
			table_rows += "<tr><td>" + invite.getSender().getUsername() + " of " + invite.getGroup().getName()
				+ "</td><td>" + invite.getMessage()
				+ "</td><td><form method=\"post\" action=\"" + Constants.baseUrl + "/invite/accept\"><input type=\"hidden\" name=\"invite_id\" value=\""+ invite.getId() +"\"><input type=\"submit\" value=\"accept\"></form>"
				+ "</td><td><form method=\"post\" action=\"" + Constants.baseUrl + "/invite/decline\"><input type=\"hidden\" name=\"invite_id\" value=\""+ invite.getId() +"\"><input type=\"submit\" value=\"decline\"></form>"
				+ "</td></tr>";
		}
		
		request.setAttribute("table_rows", table_rows);
		
		String destination = "/invite_browse.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
