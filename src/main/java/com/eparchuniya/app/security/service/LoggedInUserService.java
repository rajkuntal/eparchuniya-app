package com.eparchuniya.app.security.service;

import com.eparchuniya.app.domain.admin.User;

public interface LoggedInUserService {
	
	String getUserName();
	
	 User getUser();

}
