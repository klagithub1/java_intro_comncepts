package org.soenea.doitall.domain.model.person.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;

public abstract class PersonTDG {
	public static final String BASE_NAME = "person";
	public static final String TABLE = DbRegistry.getTablePrefix()+BASE_NAME;
	public static final String INSERT = "INSERT INTO " + TABLE + " (id,version,name,age) VALUES (?,?,?,?);";
	public static final String UPDATE = "UPDATE " + TABLE + " AS p set p.age=?, p.version=p.version+1 WHERE p.id=? AND p.version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.id=? AND p.version=?;";
	
	public static final String SELECT_ALL = "SELECT p.id, p.version, p.name, p.age FROM " + TABLE + " AS p;";
	public static final String SELECT = "SELECT p.id, p.version, p.name, p.age FROM " + TABLE + " AS p WHERE p.id=?;";
	
	public static ResultSet findAll() throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
		return ps.executeQuery();
	}
	
	public static ResultSet find(long id) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		ps.setLong(1, id);
		return ps.executeQuery();
	}
	
	public static void insert(long id, int version, String name, int age) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, id);
		ps.setInt(2, version);
		ps.setString(3, name);
		ps.setInt(4, age);
		ps.executeUpdate();
		ps.close();
	}

	public static int update(long id, int version, int age) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		ps.setInt(1, age);
		ps.setLong(2, id);
		ps.setInt(3, version);		
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

	public static int delete(long id, int version) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
		ps.setLong(1, id);
		ps.setInt(2, version);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}
}
