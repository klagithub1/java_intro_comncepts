package technical;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class PersonRDG {
	public static final String BASE_NAME = "person";
	public static final String TABLE = DbRegistry.getTablePrefix()+BASE_NAME;
	public static final String INSERT = "INSERT INTO " + TABLE + " (name,age) VALUES (?,?);";
	public static final String UPDATE = "UPDATE " + TABLE + " AS p set p.age=? WHERE p.name=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.name=?;";
	
	public static final String SELECT_ALL = "SELECT p.name, p.age FROM " + TABLE + " AS p;";
	public static final String SELECT = "SELECT p.name, p.age FROM " + TABLE + " AS p WHERE p.name=?;";
	
	public static List<PersonRDG> findAll() throws SQLException {
		List<PersonRDG> result = new Vector<PersonRDG>();
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			result.add(new PersonRDG(rs.getString("p.name"), rs.getInt("p.age")));
		}
		ps.close();
		return result;
	}
	
	public static PersonRDG find(String name) throws SQLException {
		PersonRDG result = null;
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			result = new PersonRDG(rs.getString("p.name"), rs.getInt("p.age"));
		}
		ps.close();
		return result;
	}
	
	private String name;
	private int age;
	public PersonRDG(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	public void insert() throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.execute();
	}

	public void update() throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		ps.setInt(1, age);
		ps.setString(2, name);
		ps.execute();		
	}

	public void delete() throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
		ps.setString(1, name);
		ps.execute();		
	}

}
