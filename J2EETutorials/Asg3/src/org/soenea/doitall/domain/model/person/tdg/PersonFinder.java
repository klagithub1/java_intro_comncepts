package org.soenea.doitall.domain.model.person.tdg;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;


public class PersonFinder {

	public static final String SELECT_ALL = "SELECT id, version, first_name, last_name, user_id FROM " + PersonTDG.TABLE + ";";
	public static final String SELECT = "SELECT id, version, first_name, last_name, user_id FROM " + PersonTDG.TABLE + " WHERE id=?;";
	
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

