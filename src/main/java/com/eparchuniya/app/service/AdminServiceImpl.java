package com.eparchuniya.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eparchuniya.app.dao.StoreDao;
import com.eparchuniya.app.dao.UserDao;
import com.eparchuniya.app.dao.UserRoleDao;
import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.domain.UserRole;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private StoreDao storeDao; 
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;

	public Store saveStore(Store store) {
		return storeDao.save(store);
	}

	public void updateStore(Store store) {
		storeDao.update(store);
		
	}

	public void deleteStore(Store store) {
		storeDao.delete(store);
		
	}

	public Store findStoreByStoreId(int storeId) {
		return storeDao.findById(storeId);
	}

	public long countAllStores() {
		return storeDao.countAll();
	}

	public List<Store> getAllStores() {
		return storeDao.findAll();
	}

	public Store findStoreByCode(String code) {
		return storeDao.findByCode(code);
	}

	public Store findStoreByName(String name) {
		return storeDao.findByName(name);
	}
	
	
	/* ------------------- User Services ---------------------- */
	
	public User saveUser(User user) {
		return userDao.save(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
		
	}

	public void deleteUser(User user) {
		userDao.delete(user);
		
	}

	public User findUserByUserId(int userId) {
		return userDao.findById(userId);
	}

	public long countAllUsers() {
		return userDao.countAll();
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User findUserByName(String userName) {
		return userDao.findByName(userName);
	}

	
	/* ------------------- User Role Services ---------------------- */
	
	public UserRole saveUserRole(UserRole userRole) {
		return userRoleDao.save(userRole);
	}

	public void updateUserRole(UserRole userRole) {
		userRoleDao.update(userRole);
		
	}

	public void deleteUserRole(UserRole userRole) {
		userRoleDao.delete(userRole);
		
	}

	public UserRole findUserByUserRoleId(int userRoleId) {
		return userRoleDao.findById(userRoleId);
	}

	public long countAllUserRoles() {
		return userRoleDao.countAll();
	}

	public List<UserRole> getAllUserRoles() {
		return userRoleDao.findAll();
	}
}
