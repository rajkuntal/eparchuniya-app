package com.eparchuniya.app.security.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.eparchuniya.app.dao.admin.UserDao;
import com.eparchuniya.app.domain.admin.User;

@Component("loggedInUserService")
public class LoggedInUserServiceImpl implements LoggedInUserService {
	
	@Autowired
	private UserDao userDao;
	
	private Map<String, User> nameToUser = new ConcurrentHashMap<String, User>();

	public String getUserName() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	public User getUser() {
		
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		
		if(nameToUser.containsKey(userName)){
			return nameToUser.get(userName);
		}
		User user = userDao.findByName(userName);
		if(user != null)
			nameToUser.put(userName, user);
		return user;
	}

}
