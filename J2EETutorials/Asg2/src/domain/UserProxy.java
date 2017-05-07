package domain;

import mapper.UserMapper;

public class UserProxy implements IUser {

	public final int id;
	private User real;
	
	public UserProxy(int id) {
		
		super();
		this.id = id;
	}
	
	private User getReal() {
		
		if(this.real == null)
			this.real = UserMapper.find(id);
		
		return this.real;
	}
	
	@Override
	public String getUsername() {
		return getReal().getUsername();
	}

	@Override
	public void setUsername(String username) {
		getReal().setUsername(username);
	}

	@Override
	public String getPassword() {
		return getReal().getPassword();
	}

	@Override
	public void setPassword(String password) {
		getReal().setPassword(password);
	}

	@Override
	public String getFirstName() {
		return getReal().getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		getReal().setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		return getReal().getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		getReal().setLastName(lastName);
	}

	@Override
	public boolean isAdmin() {
		return getReal().isAdmin();
	}

	@Override
	public void setAdmin(boolean isAdmin) {
		getReal().setAdmin(isAdmin);
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
	public int getId() {
		return this.id;
	}
}
