package org.soenea.doitall.domain.model.invite;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.uow.UoW;
import org.soenea.doitall.domain.model.guild.IGuild;
import org.soenea.doitall.domain.model.invite.tdg.InviteTDG;

public class InviteFactory {

	public static final long FIRST_VERSION = 1;
	
	public static Invite createNew(String message, IGuild guild, IUser sender, IUser recipient) throws SQLException, MapperException {
		
		Invite result = new Invite(
			InviteTDG.getMaxId(),
			FIRST_VERSION,
			message,
			guild,
			sender,
			recipient
		);
		
		UoW.getCurrent().registerNew(result);
		
		return result;
	}
	public static Invite createClean(long id, long version, String message, IGuild guild, IUser sender, IUser recipient) throws SQLException {
		
		Invite result = new Invite(
			id,
			version,
			message,
			guild,
			sender,
			recipient
		);
		
		UoW.getCurrent().registerClean(result);
		
		return result;
	}
		
}
