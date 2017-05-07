package org.soenea.doitall.domain.model.person.tdg;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.dsrg.soenea.service.UniqueIdFactory;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public class PersonTDG {

	public static final String BASE_NAME = "person";
	public static final String TABLE = DbRegistry.getTablePrefix() + BASE_NAME;
	public static final String INSERT = "INSERT INTO " + TABLE + " (id, version, first_name, last_name, user_id) VALUES (?,?,?,?,?);";
	public static final String UPDATE = "UPDATE " + TABLE + " SET version=version+1, first_name=?, last_name=?, user_id=? WHERE id=? AND version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE id=? AND version=?;";
	
	public static void insert(long id, long version, String first, String last, long userId) throws SQLException {
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, id);
		ps.setLong(2, version);
		ps.setString(3, first);
		ps.setString(4, last);
		
		if(userId == 0)
			ps.setLong(5, userId);
		else
			ps.setNull(5, Types.INTEGER);
		
		ps.executeUpdate();
		ps.close();
	}	
	
	public static int update(long id, long version, String first, String last, long userId) throws SQLException {
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		
		// Arguments
		ps.setString(1, first);
		ps.setString(2, last);

		if(userId == 0)
			ps.setLong(3, userId);
		else
			ps.setNull(3, Types.INTEGER);
		
		// Where
		ps.setLong(4, id);
		ps.setLong(5, version);		
		
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
