package com.application;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Invite;
import com.domain.InviteMapper;
 
public class InviteBrowsePC  {

	public String execute(HttpServletRequest request) {
		try{
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


