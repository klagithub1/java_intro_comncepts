package gateway;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Statement;

import service.Constants;

public class InviteTDG {

	public static String TABLE = "invite";
	
	public static ResultSet find(int id) {
		
		ResultSet output = null;
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("SELECT * FROM " + TABLE + " WHERE id = ?");
			statement.setLong(1, id);
		
			output = statement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static ResultSet findAll() {
		
		ResultSet output = null;
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("SELECT * FROM " + TABLE);
		
			output = statement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static int insert(Date date, String message, int groupId, int senderId, int recipientId) {
		
		int output = -1;
		
		try {
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mysqlDate = sdf.format(date);
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("INSERT INTO " + TABLE + " (message, guild_id, sender_id, recipient_id, date) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, message);
			statement.setInt(2, groupId);
			statement.setInt(3, senderId);
			statement.setInt(4, recipientId);
			statement.setString(5, mysqlDate);
			statement.executeUpdate();
			
			ResultSet keyStatement = statement.getGeneratedKeys();
	        if (keyStatement.next()) {
	        	output = keyStatement.getInt(1);
	        } else {
	            throw new SQLException("Weird error; No autokey returned");
	        }
			
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static void update(Date date, int id, String message, int groupId, int senderId, int recipientId) {
		
		try {
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mysqlDate = sdf.format(date);
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("UPDATE " + TABLE + " SET message=?, guild_id=?, sender_id=?, recipient_id=?, date=? WHERE id=?");
			statement.setString(1, message);
			statement.setInt(2, groupId);
			statement.setInt(3, senderId);
			statement.setInt(4, recipientId);
			statement.setString(5, mysqlDate);
			statement.setInt(6, id);
			
			if(groupId > 1) {
				statement.setInt(6, groupId);
			} else {
				statement.setNull(6, java.sql.Types.INTEGER);
			}
			
			statement.executeUpdate();
			statement.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int id) {
		
		PreparedStatement statement;
		try {
			
			statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("DELETE FROM " + TABLE + " WHERE id=?");
			statement.setInt(1, id);
			
			statement.executeUpdate();
			statement.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet findAllTo(int id) {
		
		ResultSet output = null;
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("SELECT * FROM " + TABLE + " WHERE recipient_id = ?");
			statement.setInt(1, id);
			
			output = statement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}

	public static void deleteAllTo(int id) {
		
		PreparedStatement statement;
		try {
			
			statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("DELETE FROM " + TABLE + " WHERE recipient_id = ?");
			statement.setInt(1, id);
			
			statement.executeUpdate();
			statement.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
