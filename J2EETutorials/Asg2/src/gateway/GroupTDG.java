package gateway;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import service.Constants;

public class GroupTDG {

	public static String TABLE = "guild";
	
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
	
	public static int insert(String name) {
		
		int output = -1;
		
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("INSERT INTO " + TABLE + " (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, name);
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
	
	public static void update(int id, String name) {
		
		try {
			
			PreparedStatement statement = DriverManager.getConnection(Constants.url, Constants.user, Constants.password)
				.prepareStatement("UPDATE " + TABLE + " SET name=? WHERE id=?");
			statement.setString(1, name);
			statement.setInt(2, id);
			
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
}
