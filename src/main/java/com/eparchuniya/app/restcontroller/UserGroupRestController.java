package com.eparchuniya.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.dao.UserGroupDAO;
import com.eparchuniya.app.domain.UserGroup;

@RestController
public class UserGroupRestController {

	@Autowired
	UserGroupDAO userGroupDAO;

	@ResponseBody
	@RequestMapping(value = "/REST/usergroupmanagement/addUserGroup", method = RequestMethod.POST)
	public ResponseEntity<List<UserGroup>> addUserGroup(@RequestBody UserGroup userGroup) {
		userGroupDAO.addUserGroup(userGroup);
		List<UserGroup> userGroups = userGroupDAO.findAllUserGroup();

		return new ResponseEntity<List<UserGroup>>(userGroups, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteUserGroup", method = RequestMethod.POST)
	public String deleteUserGroup(UserGroup userGroup) {
		userGroupDAO.removeUserGroup(userGroup);
		return "usergroupmanagement";
	}

	@ResponseBody
	@RequestMapping(value = "/REST/usergroupmanagement/usergroups", method = RequestMethod.GET)
	public ResponseEntity<List<UserGroup>> getAllUserGroups() {
		
		List<UserGroup> userGroups = userGroupDAO.findAllUserGroup();

		return new ResponseEntity<List<UserGroup>>(userGroups, HttpStatus.OK);
	}

}
