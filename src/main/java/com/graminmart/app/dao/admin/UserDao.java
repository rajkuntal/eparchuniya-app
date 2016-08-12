package com.graminmart.app.dao.admin;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.admin.User;

public interface UserDao extends GenericDoa<User, Integer>{
	
	User findByName(String userName);
	
	boolean deactivateUser(int userId, int empId);
	
	boolean activateUser(int userId, int empId);

}
