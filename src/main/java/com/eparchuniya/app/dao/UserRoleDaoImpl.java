package com.eparchuniya.app.dao;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.UserRole;

@Repository("userRoleId")
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole, Integer> implements UserRoleDao {

}
