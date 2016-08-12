package com.graminmart.app.security.service;

import com.graminmart.app.domain.admin.User;

public interface LoggedInUserService {
	
	String getUserName();
	
	 User getUser();

}
