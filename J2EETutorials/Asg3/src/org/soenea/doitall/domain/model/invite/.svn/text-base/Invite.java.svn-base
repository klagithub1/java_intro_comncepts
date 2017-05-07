package org.soenea.doitall.domain.model.invite;
import org.dsrg.soenea.domain.DomainObject;
import org.dsrg.soenea.domain.user.IUser;
import org.soenea.doitall.domain.model.guild.IGuild;
 

public class Invite extends DomainObject<Long> implements IInvite  {

	private String message;
	private IGuild guild;
	private IUser sender;
	private IUser recipient;
	
	public Invite(long id, long version, String message, IGuild guild, IUser sender, IUser recipient) {
		
		super(id, version);
		this.message = message;
		this.guild = guild;
		this.sender = sender;
		this.recipient = recipient;
	}	

	@Override
	public String getMessage() {
		
		return message;
	}

	@Override
	public void setMessage(String message) {
		
		this.message = message;
	}

	@Override
	public IGuild getGuild() {
		
		return guild;
	}

	@Override
	public void setGuild(IGuild guild) {
		
		this.guild = guild;
	}

	@Override
	public IUser getSender() {
		
		return sender;
	}

	@Override
	public void setSender(IUser sender) {
		
		this.sender = sender;
	}

	@Override
	public IUser getRecipient() {
		
		return recipient;
	}

	@Override
	public void setRecipient(IUser recipient) {
		
		this.recipient = recipient;
	}
}


