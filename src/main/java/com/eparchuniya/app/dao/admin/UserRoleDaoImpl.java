package com.eparchuniya.app.dao.admin;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.admin.UserRole;

@Repository("userRoleId")
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole, Integer> implements UserRoleDao {

}
