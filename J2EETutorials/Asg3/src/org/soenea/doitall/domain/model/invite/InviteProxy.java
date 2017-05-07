package org.soenea.doitall.domain.model.invite;

import java.sql.SQLException;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;
import org.dsrg.soenea.domain.user.IUser;

import org.soenea.doitall.domain.model.guild.IGuild;
import org.soenea.doitall.domain.model.invite.mapper.InviteInputMapper;

public class InviteProxy extends DomainObjectProxy<Long, Invite> implements IInvite {

	protected InviteProxy(Long id) {
		
		super(id);
	}

	@Override
	protected Invite getFromMapper(Long id) throws MapperException, DomainObjectCreationException {
		
		try {
			
			return InviteInputMapper.find(id);
			
		} catch (final SQLException e) {
			
			throw new MapperException(e);
		}
	}
	
	@Override
	public String getMessage() {
		
		return getInnerObject().getMessage();
	}

	@Override
	public void setMessage(String message) {
		
		 getInnerObject().setMessage(message);
	}

	@Override
	public IGuild getGuild() {
		return getInnerObject().getGuild();
	}

	@Override
	public void setGuild(IGuild guild) {
		
		 getInnerObject().setGuild(guild);
	}

	@Override
	public IUser getSender() {
		
		return getInnerObject().getSender();
	}

	@Override
	public void setSender(IUser sender) {
		
		  getInnerObject().setSender(sender);
	}

	@Override
	public IUser getRecipient() {
		
		return getInnerObject().getRecipient();
	}

	@Override
	public void setRecipient(IUser recipient) {
		
		 getInnerObject().setRecipient(recipient);
	}
}
