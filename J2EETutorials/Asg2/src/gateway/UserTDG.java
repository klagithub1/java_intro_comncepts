package gateway;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.Constants;

public class UserTDG {

	public static String TABLE = "user";
	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public static int insert(String username, String password, String firstName, String lastName, boolean isAdmin, int groupId) {
		
		int output = -1;
		
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("INSERT INTO " + TABLE + " (username, password, first_name, last_name, admin, guild_id) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setBoolean(5, isAdmin);
			
			if(groupId > 1) {
				statement.setInt(6, groupId);
			} else {
				statement.setNull(6, java.sql.Types.INTEGER);
			}
			
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
	
	public static void update(int id, String username, String password, String firstName, String lastName, boolean isAdmin, int groupId) {
		
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("UPDATE " + TABLE + " SET username=?, password=?, first_name=?, last_name=?, admin=?, guild_id=? WHERE id=?");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setBoolean(5, isAdmin);
			statement.setInt(7, id);
			
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
	
	public static ResultSet findByUsername(String username) {
	
		ResultSet output = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("SELECT * FROM " + TABLE + " WHERE username = ?");
			statement.setString(1, username);
		
			output = statement.executeQuery();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}

	public static ResultSet findByGroupId(int groupId) {

		ResultSet output = null;
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("SELECT * FROM " + TABLE + " where guild_id = " + groupId);
		
			output = statement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}

	public static ResultSet findAllAlone() {

		ResultSet output = null;
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("SELECT * FROM " + TABLE + " where guild_id IS NULL");
		
			output = statement.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
}
