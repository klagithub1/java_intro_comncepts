package org.soenea.doitall.domain.model.invite;
import org.dsrg.soenea.domain.interf.IDomainObject;
import org.dsrg.soenea.domain.user.IUser;
import org.soenea.doitall.domain.model.guild.IGuild;
 

public interface IInvite extends IDomainObject<Long> {

	public String getMessage();
	public void setMessage(String message);
	
	public IGuild getGuild();
	public void setGuild(IGuild guild);
	
	public IUser getSender();
	public void setSender(IUser sender);
	
	public IUser getRecipient();
	public void setRecipient(IUser recipient);
}
 