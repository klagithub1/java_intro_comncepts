package org.soenea.doitall.domain.model.invite.mapper;

import java.sql.SQLException;
import java.util.Date;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.GenericOutputMapper;
import org.dsrg.soenea.domain.mapper.LostUpdateException;
import org.soenea.doitall.domain.model.guild.Guild;
import org.soenea.doitall.domain.model.invite.Invite;
import org.soenea.doitall.domain.model.invite.tdg.InviteTDG;
  
public class InviteOutputMapper extends GenericOutputMapper<Long, Invite> {
	
	public void insert(Invite i) throws MapperException {
		
		try {
			
			InviteTDG.insert(
				i.getId(), 
				i.getVersion(), 
				i.getMessage(), 
				i.getGuild() == null ? 0 : i.getGuild().getId(), 
				i.getSender() == null ? 0 : i.getSender().getId(),  
				i.getRecipient() == null ? 0 : i.getRecipient().getId(), 
				new Date()
			);
			
		} catch (SQLException e) {

			throw new MapperException("Could not insert Invite " + i.getId(), e);
		}
	}

	public void update(Invite i) throws MapperException {
		
		int count;
		try {
			
			count = InviteTDG.update(
				i.getId(), 
				i.getVersion(), 
				i.getMessage(),
				i.getGuild() == null ? 0 : i.getGuild().getId(), 
				i.getSender() == null ? 0 : i.getSender().getId(), 
				i.getRecipient() == null ? 0 : i.getRecipient().getId()
			);
			
		} catch (SQLException e) {

			throw new MapperException("Could not update Invite " + i.getId(), e);
		}
		
		if(count == 0)
			throw new LostUpdateException("InviteTDG: id " + i.getId() +  " version " + i.getVersion());
		
		i.setVersion(i.getVersion() + 1);
	}
	
	public void delete(Invite i) throws MapperException {
		
		int count;
		try {
			
			count = InviteTDG.delete(i.getId(), i.getVersion());
			
		} catch (SQLException e) {

			throw new MapperException("Could not delete Invite " + i.getId(), e);
		}
		
		if(count == 0)
			throw new LostUpdateException("InviteTDG: id " + i.getId() +  " version " + i.getVersion());
	}
	
	public static void deleteAllFromGuild(Guild g) throws LostUpdateException, SQLException {
		
		int count = InviteTDG.deleteAllFromGuild(g.getId());
		
		if(count == 0)
			throw new LostUpdateException("InviteTDG: No invite found under guild " + g.getId());
	}
}

