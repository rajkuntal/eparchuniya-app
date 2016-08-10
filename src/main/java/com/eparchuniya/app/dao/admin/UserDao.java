package com.eparchuniya.app.dao.admin;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.admin.User;

public interface UserDao extends GenericDoa<User, Integer>{
	
	User findByName(String userName);
	
	boolean deactivateUser(int userId, int empId);
	
	boolean activateUser(int userId, int empId);

}
