package org.soenea.doitall.domain.command;
import java.sql.SQLException;



import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.user.User;
import org.dsrg.soenea.domain.user.mapper.UserInputMapper;
import org.soenea.doitall.domain.model.group.Group;
import org.soenea.doitall.domain.model.group.mapper.GroupInputMapper;
import org.soenea.doitall.domain.model.group.mapper.GroupOutputMapper;


public class GroupDisbandCommand  extends DomainCommand {

	public GroupDisbandCommand(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws CommandException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process() throws CommandException {
		// TODO Auto-generated method stub
		
		try {
		long id = (Long) helper.getAttribute("user_id");
		long version = (Long) helper.getAttribute("version");
		
		User user = UserInputMapper.find(id);
		Group group;
		
		group = GroupInputMapper.find(user.getId());
		
		helper.setRequestAttribute("group", group);
		group.setVersion(version);
		group.setName(group.getName());
		
		//check if group is null then do something...
		
		GroupOutputMapper.delete(group);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MapperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//OUTPUT HERE
		
	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub
		
	}

}
