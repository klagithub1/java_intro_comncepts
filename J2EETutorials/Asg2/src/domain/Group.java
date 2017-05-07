package domain;

public class Group implements IGroup {

	public final int id;
	private String name;
	
	public Group() {
		
		super();
		this.id = -1;
	}
	
	public Group(int id) {
		
		super();
		this.id = id;
	}
	
	public Group(String name) {
		
		super();
		this.id = -1;
		this.name = name;
	}
	
	public Group(int id, String name) {
		
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}
}
