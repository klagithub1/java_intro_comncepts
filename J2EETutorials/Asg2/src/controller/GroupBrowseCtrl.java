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

import mapper.GroupMapper;

import service.Constants;

/**
 * Servlet implementation class GroupBrowseCtrl
 */
public class GroupBrowseCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupBrowseCtrl() {
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
		
		List<IGroup> groups = GroupMapper.findAll();
		
		String table_rows = "";
		for (int i = 0; i < groups.size(); ++i) {
			
			IGroup g = groups.get(i);
			table_rows += "<tr><td>" + g.getName() + "</td><td>?</td></tr>";
		}
		
		request.setAttribute("table_rows", table_rows);
		
		String destination = "/group_browse.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
