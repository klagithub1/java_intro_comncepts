package com.application;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Invite;
import com.domain.InviteMapper;
 
public class InviteUserPC  {

	public String execute(HttpServletRequest request) {
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			String message = request.getParameter("message");
			int groupID = Integer.parseInt(request.getParameter("groupID"));
			int recipientID = Integer.parseInt(request.getParameter("recipientID"));
			String status = "";
			
			//NOT SURE ABOUT LAYER BREAKING HERE...
			
			Invite invite = new Invite(id,message,groupID,recipientID,status);
			InviteMapper.insert(invite);
			
			List<Invite> invites = new Vector<Invite>();
			invites = InviteMapper.findAll();
			request.setAttribute("invites", invites);	
			
			
			return  "/WEB-INF/jsp/InviteBrowse.jsp";
		}
		catch(Exception e){
			e.printStackTrace();
			return  "/WEB-INF/jsp/InviteBrowse.jsp";
		}
	}

}


