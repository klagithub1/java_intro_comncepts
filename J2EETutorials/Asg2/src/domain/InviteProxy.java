package domain;

import mapper.InviteMapper;

public class InviteProxy implements IInvite {

	public final int id;
	private Invite real;
	
	public InviteProxy(int id) {
		
		super();
		this.id = id;
	}
	
	private Invite getReal() {
		
		if(this.real == null)
			this.real = InviteMapper.find(id);
		
		return this.real;
	}
	
	
	public String getMessage() {
		return getReal().getMessage();
	}

	@Override
	public void setMessage(String message) {
		getReal().setMessage(message);
	}

	@Override
	public IGroup getGroup() {
		return getReal().getGroup();
	}

	@Override
	public void setGroup(IGroup group) {
		getReal().setGroup(group);
	}

	@Override
	public IUser getSender() {
		return getReal().getSender();
	}

	@Override
	public void setSender(IUser sender) {
		getReal().setSender(sender);
	}

	@Override
	public IUser getRecipient() {
		return getReal().getRecipient();
	}

	@Override
	public void setRecipient(IUser recipient) {
		getReal().setRecipient(recipient);
	}

	@Override
	public int getId() {
		return this.id;
	}

}
