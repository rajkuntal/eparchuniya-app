package com.eparchuniya.app.dao;


import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer>implements UserDao {

	public User findByName(String userName) {
//		User user = (User) em.createQuery("SELECT s FROM User s WHERE s.userName = ?0")
//				.setParameter(0, userName).getSingleResult();
		User user = (User) em.createQuery("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.userName = ?0")
					.setParameter(0, userName).getSingleResult();
		if (user != null)
			return user;
		else
			return null;
	}

}
