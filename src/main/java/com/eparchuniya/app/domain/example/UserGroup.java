package com.eparchuniya.app.domain.example;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "userGroup")
public class UserGroup {

	//@Id
	private String userGroupId;
	
	private String userGroupName;
	
	private String isActive;

	
	public UserGroup() {
		super();
	}

	public UserGroup(String userGroupId, String userGroupName, String isActive) {
		super();
		this.userGroupId = userGroupId;
		this.userGroupName = userGroupName;
		this.isActive = isActive;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	

}
