package domain;

public interface IInvite {

	public int getId();
	public String getMessage();
	public void setMessage(String message);
	public IGroup getGroup();
	public void setGroup(IGroup group);
	public IUser getSender();
	public void setSender(IUser sender);
	public IUser getRecipient();
	public void setRecipient(IUser recipient);
}
