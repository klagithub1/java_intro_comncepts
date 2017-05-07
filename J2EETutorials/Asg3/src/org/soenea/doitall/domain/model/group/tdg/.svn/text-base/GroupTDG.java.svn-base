package org.soenea.doitall.domain.model.group.tdg;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.dsrg.soenea.service.UniqueIdFactory;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class GroupTDG {

	
	
	public static final String BASE_NAME = "group";
	public static final String TABLE = DbRegistry.getTablePrefix() + BASE_NAME;
	public static final String INSERT = "INSERT INTO " + TABLE + " (id, version, name) VALUES (?,?,?);";
	public static final String UPDATE = "UPDATE " + TABLE + " SET name=?, version=version+1 WHERE id=? AND version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE id=? AND version=?;";

	
	
public static void insert(long id, long version, String name) throws SQLException {
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String mysqlDate = sdf.format(date);
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, id);
		ps.setLong(2, version);
		ps.setString(3, name);
		
		
		
		//ps.setString(7, mysqlDate);
		ps.executeUpdate();
		ps.close();
	}	
	public static int update(long id, long version, String name) throws SQLException {
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		
		// Arguments
		ps.setString(3,name);

		
		// Where
		ps.setLong(1, id);
		ps.setLong(2, version);		
		
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}	
	public static int delete(long id, long version) throws SQLException {
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE);
		ps.setLong(1, id);
		ps.setLong(2, version);
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}
	
	public static long getMaxId() throws SQLException {
		
		return UniqueIdFactory.getMaxId(BASE_NAME, "id");
	}
	
	
}
