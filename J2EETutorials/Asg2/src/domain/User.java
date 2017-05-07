package domain;

public class User implements IUser {

	public final int id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isAdmin;
	private IGroup group;
	
public User() {
		
		super();
		this.id = -1;
	}
	
	public User(int id) {
		
		super();
		this.id = id;
	}

	public User(int id, String username, String password, String firstName, String lastName, boolean isAdmin, int groupId) {
		
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.group = (groupId > 0) ?
			new GroupProxy(groupId) :
			null;
	}
	
	public User(String username, String password, String firstName, String lastName, boolean isAdmin, int groupId) {
		
		super();
		this.id = -1;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.group = (groupId > 0) ?
			new GroupProxy(groupId) :
			null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public IGroup getGroup() {
		return group;
	}

	public void setGroup(IGroup group) {
		this.group = group;
	}

	public int getId() {
		return this.id;
	}
}
