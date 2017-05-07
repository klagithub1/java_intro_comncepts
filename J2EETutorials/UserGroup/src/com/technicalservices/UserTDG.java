package com.technicalservices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public abstract class UserTDG implements TableDataGateway
{
	public static final String BASE_NAME = "user";
	public static final String TABLE = DbRegistry.getTablePrefix()+BASE_NAME;
	public static final String INSERT = "INSERT INTO "+ TABLE + " (id, username, password, first_name, last_name, admin)VALUES (?,?,?,?,?,?);";
	
	public static final String UPDATE = "UPDATE " + TABLE + " AS p SET p.username=?, p.password=?, p.first_name=?, p.last_name=?, p.admin=? WHERE p.id=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.id=?;";
	public static final String DELETE2 = "DELETE FROM "+ TABLE + " WHERE id=?";
	public static final String SELECT_ALL = "SELECT * FROM " + TABLE + " AS p;";
	public static final String SELECT_USERNAME = "SELECT * FROM " + TABLE + " AS p WHERE p.username=?;";
	public static final String SELECT = "SELECT p.id, p.username, p.password, p.first_name, p.last_name, p.admin FROM " + TABLE + " AS p WHERE p.id=?;";
	
	
	public static ResultSet findAll() throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
		return ps.executeQuery();
	}
	
	public static ResultSet find(long id) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		ps.setLong(1, id);
		return ps.executeQuery();
	}
	
	public static ResultSet findByUserName(String username) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_USERNAME);
		ps.setString(1, username);
		return ps.executeQuery();
	}
	
	public static void insert(long id, String username, String password, String first_name, String last_name, boolean admin) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, id);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.setString(4, first_name);
		ps.setString(5, last_name);
		ps.setBoolean(6, admin);
		ps.executeUpdate();
		ps.close();
	}

	public static int update(long id, String username, String password, String first_name, String last_name, boolean admin) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, first_name);
		ps.setString(4, last_name);
		ps.setBoolean(5, admin);
		ps.setLong(6, id);	
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

	public static int delete(long id) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE2);
		ps.setLong(1, id);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}
}