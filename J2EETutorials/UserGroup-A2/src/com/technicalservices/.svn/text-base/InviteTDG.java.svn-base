package com.technicalservices;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public abstract class InviteTDG implements TableDataGateway
{
	public static final String BASE_NAME = "invite";
	public static final String TABLE = DbRegistry.getTablePrefix()+BASE_NAME;
	public static final String INSERT = "INSERT INTO "+ TABLE + " (id, message,groupID,recipientID, status)VALUES (?,?,?,?,?);";
	public static final String UPDATE = "UPDATE " + TABLE + " AS p SET p.message=?, p.groupID=?, p.recipientID=?,p.status=? WHERE p.id=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.id=?;";	
	public static final String SELECT_ALL = "SELECT * FROM " + TABLE + " AS p;";
	public static final String SELECT = "SELECT p.id, p.message, p.groupID, p.recipientID,p.status FROM " + TABLE + " AS p WHERE p.id=?;";
	
	public static ResultSet findAll() throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
		return ps.executeQuery();
	}
	
	public static ResultSet find(int id) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		ps.setInt(1, id);
		return ps.executeQuery();
	}

	public static void insert(int id, String message, int groupID, int recipientID, String status) throws SQLException
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setInt(1, id);
		ps.setString(2, message);
		ps.setInt(3, groupID);
		ps.setInt(4, recipientID);
		ps.setString(5, status);
		ps.executeUpdate();
		ps.close();
	}
	
	public static int update(int id, String message, int groupID, int recipientID, String status) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		ps.setString(1, message);
		ps.setInt(2, groupID);
		ps.setInt(2, recipientID);
		ps.setString(4, status);	
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

	public static int delete(int id) throws SQLException 
	{
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
		ps.setInt(1, id);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}


}