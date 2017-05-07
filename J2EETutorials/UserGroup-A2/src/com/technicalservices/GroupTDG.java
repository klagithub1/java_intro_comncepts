package com.technicalservices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public abstract class GroupTDG implements TableDataGateway
{
	public static final String BASE_NAME = "group";
	public static final String TABLE = DbRegistry.getTablePrefix()+BASE_NAME;
	public static final String INSERT = "INSERT INTO "+ TABLE + " (id, name)VALUES (?,?);";
	
	public static final String UPDATE = "UPDATE " + TABLE + " AS p SET p.name=? WHERE p.id=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.id=?;";
	public static final String DELETE2 = "DELETE FROM "+ TABLE + " WHERE id=?";
	public static final String SELECT_ALL = "SELECT * FROM " + TABLE + " AS p;";
	public static final String SELECT_GROUPNAME = "SELECT * FROM " + TABLE + " AS p WHERE p.name=?;";
	public static final String SELECT = "SELECT p.id, p.name FROM " + TABLE + " AS p WHERE p.id=?;";
	
	
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
	
	public static ResultSet findByGroupName(String groupname) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_GROUPNAME);
		ps.setString(1, groupname);
		return ps.executeQuery();
	}
	
	public static void insert(long id, String groupname) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, id);
		ps.setString(2, groupname);
		
		ps.executeUpdate();
		ps.close();
	}

	public static int update(long id, String groupname) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		ps.setString(1, groupname);
		ps.setLong(2, id);	
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