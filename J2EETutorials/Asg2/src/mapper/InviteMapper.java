package mapper;

import gateway.InviteTDG;
import gateway.UserTDG;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import domain.IInvite;
import domain.Invite;

public class InviteMapper {

	public static Invite find(int id) {
		
		ResultSet rs = InviteTDG.find(id);
		Invite output = null;
		try {
			
			if(rs.next()) {
				output = new Invite(
					rs.getInt("id"),
					rs.getString("message"),
					rs.getInt("guild_id"),
					rs.getInt("sender_id"),
					rs.getInt("recipient_id")
				);
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static List<IInvite> findAll() {

		List<IInvite> output = new Vector<IInvite>();
		ResultSet rs = UserTDG.findAll();
		
		try {
			while(rs.next()) {
				
				output.add(new Invite(
						rs.getInt("id"),
						rs.getString("message"),
						rs.getInt("guild_id"),
						rs.getInt("sender_id"),
						rs.getInt("recipient_id")
				));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return output;
	}
	
	public static int insert(IInvite invite) {

		return InviteTDG.insert(
			new java.util.Date(),
			invite.getMessage(), 
			invite.getGroup().getId(), 
			invite.getSender().getId(), 
			invite.getRecipient().getId()
		);
	}
	
	public static void update(IInvite invite) {
		
		InviteTDG.update(
			new java.util.Date(), // blah
			invite.getId(), 
			invite.getMessage(), 
			invite.getGroup().getId(), 
			invite.getSender().getId(), 
			invite.getRecipient().getId()
		);
	}

	public static void delete(int id) {

		InviteTDG.delete(id);
	}

	public static List<IInvite> findAllTo(int id) {

		List<IInvite> output = new Vector<IInvite>();
		ResultSet rs = InviteTDG.findAllTo(id);
		
		try {
			while(rs.next()) {
				
				output.add(new Invite(
					rs.getInt("id"),
					rs.getString("message"),
					rs.getInt("guild_id"),
					rs.getInt("sender_id"),
					rs.getInt("recipient_id")
				));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return output;
	}

	public static void deleteAllTo(int id) {
		
		InviteTDG.deleteAllTo(id);
	}
}
