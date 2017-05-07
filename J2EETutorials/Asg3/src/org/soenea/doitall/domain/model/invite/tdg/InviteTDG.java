package org.soenea.doitall.domain.model.invite.tdg;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.dsrg.soenea.service.UniqueIdFactory;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

public abstract class InviteTDG {
	
	public static final String BASE_NAME = "invite";
	public static final String TABLE = DbRegistry.getTablePrefix() + BASE_NAME;
	public static final String INSERT = "INSERT INTO " + TABLE + " (id, version, message, guild_id, sender_id, recipient_id, date) VALUES (?,?,?,?,?,?,?);";
	public static final String UPDATE = "UPDATE " + TABLE + " SET message=?, version=version+1, guild_id=?, sender_id=?, recipient_id=? WHERE id=? AND version=?;";
	public static final String DELETE = "DELETE FROM " + TABLE + " WHERE id=? AND version=?;";
	public static final String DELETE_ALL_FROM_GUILD = "DELETE FROM " + TABLE + " WHERE guild_id = ?";
	
	public static void insert(long id, long version, String message, long guildId, long senderId, long recipientId, Date date) throws SQLException {
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mysqlDate = sdf.format(date);
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(INSERT);
		ps.setLong(1, id);
		ps.setLong(2, version);
		ps.setString(3, message);
		
		if(guildId == 0)
			ps.setLong(4, guildId);
		else
			ps.setNull(4, Types.INTEGER);
		
		if(senderId == 0)
			ps.setLong(5, senderId);
		else
			ps.setNull(5, Types.INTEGER);
		
		if(recipientId == 0)
			ps.setLong(6, recipientId);
		else
			ps.setNull(6, Types.INTEGER);
		
		ps.setString(7, mysqlDate);
		ps.executeUpdate();
		ps.close();
	}	
	
	public static int update(long id, long version, String message, long guildId, long senderId, long recipientId) throws SQLException {
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(UPDATE);
		
		// Arguments
		ps.setString(1, message);

		if(guildId == 0)
			ps.setLong(2, guildId);
		else
			ps.setNull(2, Types.INTEGER);
		
		if(senderId == 0)
			ps.setLong(3, senderId);
		else
			ps.setNull(3, Types.INTEGER);
		
		if(recipientId == 0)
			ps.setLong(4, recipientId);
		else
			ps.setNull(4, Types.INTEGER);
		
		// Where
		ps.setLong(5, id);
		ps.setLong(6, version);		
		
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
	
	public static int deleteAllFromGuild(long guildId) throws SQLException {
		
		PreparedStatement ps = DbRegistry.getDbConnection().prepareStatement(DELETE_ALL_FROM_GUILD);
		ps.setLong(1, guildId);
		int count = ps.executeUpdate();
		ps.close();
		
		return count;
	}
	
	public static long getMaxId() throws SQLException {
		
		return UniqueIdFactory.getMaxId(BASE_NAME, "id");
	}
}	

 
 

