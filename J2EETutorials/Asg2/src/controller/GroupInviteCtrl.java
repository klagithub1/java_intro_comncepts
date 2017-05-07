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
import domain.IUser;
import domain.Invite;

/**
 * Servlet implementation class GroupInvite
 */
public class GroupInviteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupInviteCtrl() {
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
		if(userGroup == null) {
			
			response.sendRedirect(Constants.baseUrl + "/group");
			return;
		}
		
		// Input check
		Object input = request.getParameter("id");
		if(input != null) {
			
			invite_form(Integer.parseInt(input.toString()), request, response);
			return;
		}
		
		
		// Fetch guildless people
		List<IUser> guildlessUsers = UserMapper.findAllAlone();
		String table_rows = null;
		for(int i = 0; i < guildlessUsers.size(); ++i) {
			
			IUser guildless = guildlessUsers.get(i);
			table_rows += "<tr><td>" + guildless.getUsername()
				+ "</td><td>" + guildless.getFirstName() + " " + guildless.getLastName()
				+ "</td><td><a href=\"" + Constants.baseUrl + "/group/invite?id=" + guildless.getId() + "\">Invite</a></td></tr>";
		}
		
		request.setAttribute("table_rows", table_rows);
		
		String destination = "/guildless_browse.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	private void invite_form(int recipientId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IUser recipient = UserMapper.find(recipientId);
		
		request.setAttribute("recipient", recipient.getUsername());
		request.setAttribute("recipient_id", recipientId);
		
		String destination = "/invite_form.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
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
		String message = request.getParameter("message");
		String recipientIdValue = request.getParameter("recipient_id");
		if(message != null && recipientIdValue != null) {
			
			if(message.length() > 0) {
			
				InviteMapper.insert(new Invite(
					message, 
					userGroup.getId(), 
					user.getId(),
					Integer.parseInt(recipientIdValue)
				));

				response.sendRedirect(Constants.baseUrl + "/group/invite");
				return;
				
			} else {
				
				request.setAttribute("msg_error", "Message cannot be left blank.");
			}
			
		} else {
			
			request.setAttribute("msg_error", "Missing fields.");
		}
		
		request.setAttribute("message", message);
		request.setAttribute("recipient_id", recipientIdValue);
		
		String destination = "/invite_form.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
