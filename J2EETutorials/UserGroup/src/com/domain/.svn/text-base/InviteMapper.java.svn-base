package com.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.List;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.LostUpdateException;

import com.technicalservices.InviteTDG;
import com.domain.Invite;
public class InviteMapper {
 
	public static Invite find(int id) throws SQLException, DomainObjectNotFoundException{
		ResultSet rs = InviteTDG.find(id);
		if(rs.next()) {
			return getInvite(rs);
		} else {
			throw new DomainObjectNotFoundException("Cannot find a person with id " + id);
		}
	}
	

	private static Invite getInvite(ResultSet rs) throws SQLException  {
		Invite invite = new Invite(
									rs.getInt("p.id"), 
									rs.getString("p.message"),
									rs.getInt("p.groupID"), 
									rs.getInt("p.recipientID"),
									rs.getString("p.status")
									);
		return invite;
	
	}
	
	public static List<Invite> findAll() throws SQLException{
		List<Invite> invites = new Vector<Invite>();
		ResultSet rs = InviteTDG.findAll();
		while(rs.next()) {
			invites.add(getInvite(rs));
		}
		return invites;
	}
	
	public static void insert(Invite i) throws LostUpdateException, SQLException {
		InviteTDG.insert(i.getId(),i.getMessage(),i.getGroupID(),i.getRecipientID(),i.getStatus());
 
	}

	public static void update(Invite i) throws LostUpdateException, SQLException {
		int count = InviteTDG.update(i.getId(),i.getMessage(),i.getGroupID(),i.getRecipientID(),i.getStatus());
		if(count == 0) {
			throw new LostUpdateException("It appears that someone else may already have changed this person.");
		}
		 
	}
	
	public static void delete(Invite i) throws LostUpdateException, SQLException {
		int count = InviteTDG.delete(i.getId());
		if(count == 0) {
			throw new LostUpdateException("It appears that someone else may already have changed this person.");
		}
	}
}
