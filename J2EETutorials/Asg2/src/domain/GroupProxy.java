package domain;

import mapper.GroupMapper;

public class GroupProxy implements IGroup {

	public final int id;
	private Group real;
	
	public GroupProxy(int id) {
		
		super();
		this.id = id;
	}
	
	private Group getReal() {
		
		if(this.real == null)
			this.real = GroupMapper.find(id);
		
		return this.real;
	}
	
	@Override
	public String getName() {
		return getReal().getName();
	}

	@Override
	public void setName(String name) {
		getReal().setName(name);
	}

	@Override
	public int getId() {
		
		return id;
	}

}
