package com.eparchuniya.app.dao.admin;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.admin.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer>implements UserDao {

	@SuppressWarnings("unchecked")
	public User findByName(String userName) {

		List<User> user = (List<User>) em.createQuery("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.userName = ?0")
				.setParameter(0, userName).getResultList();
		if (!user.isEmpty())
			return user.get(0);
		else
			return null;
	}

	public boolean deactivateUser(int userId, int empId) {
		em.createNativeQuery(
				"UPDATE admin_user SET is_active = 0, modified_by = ?1, modified_at = ?2  WHERE user_id = ?3",
				User.class).setParameter(1, empId).setParameter(2, new Date()).setParameter(3, userId).executeUpdate();
		return true;
	}

	public boolean activateUser(int userId, int empId) {

		em.createNativeQuery(
				"UPDATE admin_user SET is_active = 1, modified_by = ?1, modified_at = ?2  WHERE user_id = ?3",
				User.class).setParameter(1, empId).setParameter(2, new Date()).setParameter(3, userId).executeUpdate();
		return true;

	}

}
