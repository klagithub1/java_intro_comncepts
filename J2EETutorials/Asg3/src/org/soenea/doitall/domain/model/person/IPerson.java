package org.soenea.doitall.domain.model.person;

import org.dsrg.soenea.domain.interf.IDomainObject;
import org.dsrg.soenea.domain.user.IUser;

public interface IPerson extends IDomainObject<Long> {

	public String getFirstName();
	public void setFirstName(String first);
	
	public String getLastName();
	public void setLastName(String last);
	
	public IUser getUser();
	public void setUser(IUser user);
}
 