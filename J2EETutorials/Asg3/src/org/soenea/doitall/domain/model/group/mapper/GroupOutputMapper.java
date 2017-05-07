package org.soenea.doitall.domain.model.group.mapper;




	import java.sql.SQLException;
	
	import org.dsrg.soenea.domain.mapper.LostUpdateException;
	
	import org.soenea.doitall.domain.model.group.Group;
	import org.soenea.doitall.domain.model.group.tdg.GroupTDG;
	  
	public class GroupOutputMapper  {
		
		public static void insert(Group i) throws LostUpdateException, SQLException {
			
			GroupTDG.insert(
				i.getId(), 
				i.getVersion(), 
				i.getName()
			);
		}

		public static void update(Group i) throws LostUpdateException, SQLException {
			
			int count = GroupTDG.update(
				i.getId(), 
				i.getVersion(), 
				i.getName()
				
			);
			
			if(count == 0)
				throw new LostUpdateException("GroupTDG: id " + i.getId() +  " version " + i.getVersion());
			
			i.setVersion(i.getVersion() + 1);
		}
		
		public static void delete(Group i) throws LostUpdateException, SQLException {
			
			int count = GroupTDG.delete(i.getId(), i.getVersion());
			
			if(count == 0)
				throw new LostUpdateException("GroupTDG: id " + i.getId() +  " version " + i.getVersion());
		}
		
		
	}




