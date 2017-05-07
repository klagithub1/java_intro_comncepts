package domain;

public class Invite implements IInvite {

	public final int id;
	private String message;
	IGroup group;
	IUser sender;
	IUser recipient;
	
	public Invite() {
		
		super();
		this.id = -1;
	}
	
	public Invite(int id) {
		
		super();
		this.id = id;
	}
	
	public Invite(int id, String message, int groupId, int senderId, int recipientId) {
		
		super();
		this.id = id;
		this.message = message;
		this.group = new GroupProxy(groupId);
		this.sender = new UserProxy(senderId);
		this.recipient = new UserProxy(recipientId);
	}
	
	public Invite(String message, int groupId, int senderId, int recipientId) {
		
		super();
		this.id = -1;
		this.message = message;
		this.group = new GroupProxy(groupId);
		this.sender = new UserProxy(senderId);
		this.recipient = new UserProxy(recipientId);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IGroup getGroup() {
		return group;
	}

	public void setGroup(IGroup group) {
		this.group = group;
	}

	public IUser getSender() {
		return sender;
	}

	public void setSender(IUser sender) {
		this.sender = sender;
	}

	public IUser getRecipient() {
		return recipient;
	}

	public void setRecipient(IUser recipient) {
		this.recipient = recipient;
	}

	public int getId() {
		return id;
	}
}
