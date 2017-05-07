package org.soenea.doitall.domain.model.invite.tdg;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;


public class InviteFinder {

	public static final String SELECT_ALL = "SELECT p.id, p.version, p.datetime, p.message, p.sender_id,p.recipient_id,p.guild_id FROM " + InviteTDG.TABLE + " AS p;";
	public static final String SELECT = "SELECT p.id, p.version, p.datetime, p.message, p.sender_id,p.recipient_id,p.guild_id  FROM " + InviteTDG.TABLE + " AS p WHERE p.id=?;";
	public static final String FindAllTo = "SELECT p.id, p.version, p.datetime, p.message, p.sender_id,p.recipient_id,p.guild_id  FROM " + InviteTDG.TABLE + " AS p WHERE p.recipient_id=?;";	 
	
	public static ResultSet findAll() throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT_ALL);
		return ps.executeQuery();
	}
	
	public static ResultSet find(long id) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(SELECT);
		ps.setLong(1, id);
		return ps.executeQuery();
	}

	public static ResultSet findAllTo(int id) throws SQLException {
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(FindAllTo);
		ps.setInt(1, id);
		return ps.executeQuery();
	}
}

