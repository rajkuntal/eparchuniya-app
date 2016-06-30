package com.eparchuniya.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.UserGroup;

@Component("userGroupDAO")
public class UserGroupDAOImpl implements UserGroupDAO {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public void addUserGroup(UserGroup userGroup) {
		System.out.println("saving...");
		mongoTemplate.save(userGroup);
		
	}
	
	public void updateUserGroupName(UserGroup userGroup) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserGroupIsActive(UserGroup userGroup) {
		// TODO Auto-generated method stub
		
	}

	public void removeUserGroup(UserGroup userGroup) {
		mongoTemplate.remove(userGroup);
		
	}

	public UserGroup findUserGroupByName(UserGroup userGroup) {	
		Query query = new Query();
		query.addCriteria(Criteria.where("userGroupName").is(userGroup.getUserGroupName()));		
		return mongoTemplate.findOne(query, UserGroup.class);
	}
	
	public UserGroup findUserGroupByActiveFlag(UserGroup userGroup) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userGroupId").is(userGroup.getUserGroupId()));		
		return mongoTemplate.findOne(query, UserGroup.class);
	}

	public List<UserGroup> findAllUserGroup() {
		return mongoTemplate.findAll(UserGroup.class);
	}

}
