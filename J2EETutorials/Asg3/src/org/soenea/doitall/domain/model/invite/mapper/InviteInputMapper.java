package org.soenea.doitall.domain.model.invite.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.ObjectRemovedException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.IdentityMap;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.domain.user.UserProxy;
import org.soenea.doitall.domain.model.guild.Guild;
import org.soenea.doitall.domain.model.guild.GuildProxy;
import org.soenea.doitall.domain.model.guild.IGuild;
import org.soenea.doitall.domain.model.invite.Invite;
import org.soenea.doitall.domain.model.invite.tdg.InviteFinder;
  
public class InviteInputMapper {
	
	public static List<Invite> findAll() throws SQLException{
		
		List<Invite> invites = new Vector<Invite>();
		ResultSet rs = InviteFinder.findAll();
		
		while(rs.next())
			invites.add(getInvite(rs));
		
		return invites;
	}
	
	public static Invite find(long id) throws SQLException, MapperException {
		
		try { 
			
			return IdentityMap.get(id, Invite.class);
		}
		catch (DomainObjectNotFoundException e) { }
		catch (ObjectRemovedException e) { }
		
		ResultSet rs = InviteFinder.find(id); 
		if(!rs.next()) throw new MapperException("Invite " + id + " does not exist.");
		 
		return getInvite(rs);
	}
	
	public static List<Invite> findAllTo(int id) throws SQLException{
		
		List<Invite> people = new Vector<Invite>();
		ResultSet rs = InviteFinder.findAllTo(id);
		while(rs.next()) {
			people.add(getInvite(rs));
		}
		return people;
	}
	
	private static Invite getInvite(ResultSet rs) throws SQLException {
		
		long guildId = rs.getLong("guild_id");
		IGuild guild = (guildId != 0) ?
			new GuildProxy(guildId) :
			null;
			
		long senderId = rs.getLong("guild_id");
		IUser sender = (senderId != 0) ?
			new UserProxy(senderId) :
			null;
			
		long recipientId = rs.getLong("guild_id");
		IUser recipient = (recipientId != 0) ?
			new UserProxy(recipientId) :
			null;
		
		Invite result = new Invite(
			rs.getLong("id"),
			rs.getLong("version"),
			rs.getString("message"),
			guild,
			sender,
			recipient
		);
	
		return result;
	} 
}