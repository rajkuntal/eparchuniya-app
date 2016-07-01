package com.eparchuniya.app.dao;

import java.util.List;

import com.eparchuniya.app.domain.example.UserGroup;

public interface UserGroupDAO {
	
	void addUserGroup(UserGroup userGroup);
	
	void removeUserGroup(UserGroup userGroup);
	
	void updateUserGroupName(UserGroup userGroup);
	
	void updateUserGroupIsActive(UserGroup userGroup);
	
	UserGroup findUserGroupByName(UserGroup userGroup);
	
	UserGroup findUserGroupByActiveFlag(UserGroup userGroup);
	
	List<UserGroup> findAllUserGroup();

}
