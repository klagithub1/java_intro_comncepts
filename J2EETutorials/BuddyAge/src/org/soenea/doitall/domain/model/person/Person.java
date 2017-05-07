package org.soenea.doitall.domain.model.person;

public class Person {
	private long id;
	private int version;
	private String name;
	private int age;
	
	public Person(long id, int version, String name, int age) {
		this.id=id;
		this.version=version;
		this.name = name;
		this.age = age;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public long getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
}
