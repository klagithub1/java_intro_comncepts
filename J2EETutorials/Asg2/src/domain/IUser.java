package domain;

public interface IUser {

	public int getId();
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public boolean isAdmin();
	public void setAdmin(boolean isAdmin);
	public IGroup getGroup();
	public void setGroup(IGroup group);
}
