package mapper;

import gateway.GroupTDG;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import domain.IGroup;
import domain.Group;

public class GroupMapper {

	public static Group find(int id) {
		
		ResultSet rs = GroupTDG.find(id);
		Group output = null;
		
		if(rs != null) {
			
			try {
				
				if(rs.next()) {
				
					output = new Group(
						rs.getInt("id"),
						rs.getString("name")
					);
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return output;
	}
	
	public static List<IGroup> findAll() {

		List<IGroup> output = new Vector<IGroup>();
		ResultSet rs = GroupTDG.findAll();
		
		if(rs != null) {
			
			try {
				
				while(rs.next()) {
					
					output.add(new Group(
							rs.getInt("id"),
							rs.getString("name")
					));
				}
				
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return output;
	}
	
	public static int insert(IGroup group) {
		
		return GroupTDG.insert(
			group.getName()
		);
	}
	
	public static void update(IGroup group) {
		
		GroupTDG.update(
			group.getId(),
			group.getName()
		);
	}

	public static void delete(int id) {
		
		GroupTDG.delete(id);
	}
}
