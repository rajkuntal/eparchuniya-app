package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.User;

public interface UserDao extends GenericDoa<User, Integer>{
	
	User findByName(String userName);
	
	boolean deactivateUser(int userId, int empId);
	
	boolean activateUser(int userId, int empId);

}
