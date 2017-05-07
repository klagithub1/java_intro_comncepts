package com.application;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Invite;
import com.domain.InviteMapper;
 
public class InviteDeclinePC  {

	public String execute(HttpServletRequest request) {
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			Invite invite = InviteMapper.find(id);
			request.setAttribute("invite", invite);	
			invite.setStatus("Decline");
			InviteMapper.update(invite);
			return  "/WEB-INF/jsp/InviteView.jsp";
		}
		catch(Exception e){
			e.printStackTrace();
			return  "/WEB-INF/jsp/InviteView.jsp";
		}
		
	}

}


