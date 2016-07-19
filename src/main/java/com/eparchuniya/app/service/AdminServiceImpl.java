package com.eparchuniya.app.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eparchuniya.app.dao.StoreDao;
import com.eparchuniya.app.dao.UserDao;
import com.eparchuniya.app.dao.UserRoleDao;
import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.domain.UserRole;
import com.eparchuniya.app.domain.exception.UniqueKeyViolationException;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private StoreDao storeDao; 
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	/***************************** Store Service **********************/
	
	@Transactional()
	public Store saveStore(Store store) throws UniqueKeyViolationException {
		
//		logger.info("checking for existence of code in admin_store");
//		if(storeDao.isCodeExisting(store.getCode())) {
//			throw new UniqueKeyViolationException(store.getCode() + " --> store'code already exists in admin_store table");
//		}
		logger.info("checking for existence of name in admin_store");
		if(storeDao.isCodeExisting(store.getCode())) {
			throw new UniqueKeyViolationException(store.getName() + " --> store'name already exists in admin_store table");
		}	
		return storeDao.save(store);
	}

	@Transactional
	public void updateStore(Store store) {
		storeDao.update(store);
		
	}

	@Transactional
	public void deleteStore(Store store) {
		storeDao.delete(store);
		
	}

	@Transactional
	public Store findStoreByStoreId(int storeId) {
		return storeDao.findById(storeId);
	}

	@Transactional
	public long countAllStores() {
		return storeDao.countAll();
	}

	@Transactional
	public List<Store> getAllStores() {
		return storeDao.findAll();
	}

	@Transactional
	public Store findStoreByCode(String code) {
		return storeDao.findByCode(code);
	}

	@Transactional
	public Store findStoreByName(String name) {
		return storeDao.findByName(name);
	}
	
	@Transactional
	public boolean deactivateStore(int storeId) {
		return storeDao.deactivateStore(storeId);
	}
	
	@Transactional
	public boolean activateStore(int storeId) {
		return storeDao.deactivateStore(storeId);
	}
	
	
	/***************************** User Service **********************/
	
	@Transactional
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.update(user);
		
	}

	@Transactional
	public void deleteUser(User user) {
		userDao.delete(user);
		
	}

	@Transactional
	public User findUserByUserId(int userId) {
		return userDao.findById(userId);
	}

	@Transactional
	public long countAllUsers() {
		return userDao.countAll();
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@Transactional
	public User findUserByName(String userName) {
		return userDao.findByName(userName);
	}
	
	@Transactional
	public boolean deactivateUser(int userId, int empId) {
		return userDao.deactivateUser(userId, empId);
	}
	
	@Transactional
	public boolean activateUser(int userId, int empId) {
		return userDao.activateUser(userId, empId);
	}
	
	@Transactional
	public User createAdminUserInAppStart() {
		User user1 = new User();
		user1.setUserName("ADMIN");
		user1.setPassword("admin");
		user1.setIsActive(true);
		user1.setCreatedTs(new Date());
		
		UserRole userRole1 = new UserRole();
		userRole1.setRoleType("EPARCHUNIYA");
		userRole1.setDisplayName("ADMIN");
		userRole1.setName("ROLE_ADMIN");
		
		userRole1 = userRoleDao.save(userRole1);
		
		UserRole userRole2 = new UserRole();
		userRole2.setRoleType("EPARCHUNIYA");
		userRole2.setDisplayName("USER");
		userRole2.setName("ROLE_USER");
		
		userRole2 = userRoleDao.save(userRole2);
		
		UserRole userRole3 = new UserRole();
		userRole3.setRoleType("EPARCHUNIYA");
		userRole3.setDisplayName("USER");
		userRole3.setName("ROLE_OPS");
		
		userRole3 = userRoleDao.save(userRole3);
		
		Set<UserRole> roles = new HashSet<UserRole>();
		roles.add(userRole1);
		roles.add(userRole2);
		roles.add(userRole3);
		
		user1.setUserRoles(roles);
		return userDao.save(user1);

	}

	
	/***************************** User Role Service **********************/
	
	@Transactional
	public UserRole saveUserRole(UserRole userRole) {
		return userRoleDao.save(userRole);
	}

	@Transactional
	public void updateUserRole(UserRole userRole) {
		userRoleDao.update(userRole);
		
	}

	@Transactional
	public void deleteUserRole(UserRole userRole) {
		userRoleDao.delete(userRole);
		
	}

	@Transactional
	public UserRole findUserByUserRoleId(int userRoleId) {
		return userRoleDao.findById(userRoleId);
	}

	@Transactional
	public long countAllUserRoles() {
		return userRoleDao.countAll();
	}

	@Transactional
	public List<UserRole> getAllUserRoles() {
		return userRoleDao.findAll();
	}
	
}
