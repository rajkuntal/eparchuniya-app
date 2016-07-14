package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.User;

public interface UserDao extends GenericDoa<User, Integer>{
	
	User findByName(String userName);

}
