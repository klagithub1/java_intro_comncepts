package mapper;

import gateway.UserTDG;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import domain.IGroup;
import domain.IUser;
import domain.User;

public class UserMapper {

	public static User find(int id) {
		
		ResultSet rs = UserTDG.find(id);
		User output = null;
		try {
			
			if(rs.next()) {
				
				output = new User(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getBoolean("admin"),
					rs.getInt("guild_id")
				);
				rs.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static List<IUser> findAll() {
		
		List<IUser> output = new Vector<IUser>();
		ResultSet rs = UserTDG.findAll();
		
		try {
			while(rs.next()) {
				
				output.add(new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getBoolean("admin"),
						rs.getInt("guild_id")
				));
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return output;
	}
	
	public static int insert(IUser user) {
		
		IGroup g = user.getGroup();
		int groupId = (g == null) ?
			-1 :
			g.getId();
		
		return UserTDG.insert(
			user.getUsername(), 
			user.getPassword(), 
			user.getFirstName(), 
			user.getLastName(), 
			user.isAdmin(), 
			groupId
		);
	}
	
	public static void update(IUser user) {

		IGroup g = user.getGroup();
		int groupId = (g == null) ?
			-1 :
			g.getId();
		
		UserTDG.update(
			user.getId(), 
			user.getUsername(), 
			user.getPassword(), 
			user.getFirstName(), 
			user.getLastName(), 
			user.isAdmin(), 
			groupId
		);
	}

	public static void delete(int id) {

		UserTDG.delete(id);
	}
	
	public static User findByUsername(String username) {
		
		try {
			ResultSet rs = UserTDG.findByUsername(username);
		
			if(rs != null && rs.next()) {
				
				User user = new User(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getBoolean("admin"),
					rs.getInt("guild_id")
				);
				
				rs.close();
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<IUser> findByGroupId(int groupId) {
			
		List<IUser> output = new Vector<IUser>();
		
		try {
			
			ResultSet rs = UserTDG.findByGroupId(groupId);
			
			while(rs.next()) {
				
				output.add(new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getBoolean("admin"),
						rs.getInt("guild_id")
				));
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return output;
	}
	
	public static List<IUser> findAllAlone() {
		
		List<IUser> output = new Vector<IUser>();
		
		try {
			
			ResultSet rs = UserTDG.findAllAlone();
			
			while(rs.next()) {
				
				output.add(new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getBoolean("admin"),
						rs.getInt("guild_id")
				));
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return output;
	}
}
