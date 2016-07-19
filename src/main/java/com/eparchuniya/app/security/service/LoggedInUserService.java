package com.eparchuniya.app.security.service;

import com.eparchuniya.app.domain.User;

public interface LoggedInUserService {
	
	String getUserName();
	
	 User getUser();

}
