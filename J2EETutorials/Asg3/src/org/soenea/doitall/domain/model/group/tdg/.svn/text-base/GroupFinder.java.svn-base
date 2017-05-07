package org.soenea.doitall.domain.model.group.tdg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.soenea.doitall.domain.model.group.tdg.GroupTDG;

public class GroupFinder {
	
	
	
	public static final String SELECT_ALL = "SELECT p.id, p.version, p.name FROM " + GroupTDG.TABLE + " AS p;";
	public static final String SELECT = "SELECT p.id, p.version, p.name  FROM " + GroupTDG.TABLE + " AS p WHERE p.id=?;";
		 
	
	public static ResultSet findAll() throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
		return ps.executeQuery();
	}
	
	public static ResultSet find(long id) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		ps.setLong(1, id);
		return ps.executeQuery();
	}

	

}
