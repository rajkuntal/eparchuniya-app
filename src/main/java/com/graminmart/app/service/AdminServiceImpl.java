package com.graminmart.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graminmart.app.dao.admin.LocationServedDao;
import com.graminmart.app.dao.admin.StoreDao;
import com.graminmart.app.dao.admin.UserDao;
import com.graminmart.app.dao.admin.UserRoleDao;
import com.graminmart.app.dao.employee.DesignationDao;
import com.graminmart.app.domain.admin.LocationServed;
import com.graminmart.app.domain.admin.Store;
import com.graminmart.app.domain.admin.User;
import com.graminmart.app.domain.admin.UserRole;
import com.graminmart.app.domain.employee.Designation;
import com.graminmart.app.exception.CustomUniqueKeyViolationException;
import com.graminmart.app.exception.NotExistException;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private DesignationDao designationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private LocationServedDao locationServedDao;
	
	/***************************** Store Service **********************/
	
	public Store saveStore(Store store) throws CustomUniqueKeyViolationException {
		boolean isNameExists = storeDao.isNameExisting(store.getName());
		boolean isCodeExists = storeDao.isCodeExisting(store.getCode());
		if(isNameExists || isCodeExists){
			List<String> errors = new ArrayList<String>();
			// check if store name already exist
			if(isNameExists)
				errors.add("an store already exists with this name");
			// check if store code already exist
			if(isCodeExists)
				errors.add("an store already exists with this code");
			throw new CustomUniqueKeyViolationException(errors);
		}
		return storeDao.save(store);
	}

	public void updateStore(Store store) throws NotExistException {
		if(storeDao.findById(store.getStoreId()) == null){
			throw new NotExistException("this store does not exist");
		}
		Store storeByName = storeDao.findByName(store.getName());
		Store storeByCode = storeDao.findByName(store.getCode());
		List<String> errors = new ArrayList<String>();
		// check if store name already exist
		if(storeByName != null) {
			if(storeByName.getStoreId() != store.getStoreId()){
					errors.add("an store already exists with this name");
				throw new CustomUniqueKeyViolationException(errors);
			}
		}
		// check if store code already exist
		if(storeByCode != null) {
			if(storeByCode.getStoreId() != store.getStoreId()){
					errors.add("an store already exists with this code");
				throw new CustomUniqueKeyViolationException(errors);
			}
		}
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
	
	public boolean deactivateStore(int storeId) throws NotExistException {
		// check existense of storeId
		if(storeDao.findById(storeId) == null){
			throw new NotExistException("This store doesn't exist");
		}
		return storeDao.deactivateStore(storeId);
	}
	
	public boolean activateStore(int storeId) throws NotExistException {
		// check existense of storeId
		if(storeDao.findById(storeId) == null){
			throw new NotExistException("This store doesn't exist");
		}
		return storeDao.activateStore(storeId);
	}
	
	
	/***************************** User Service **********************/
	
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
	
	public boolean deactivateUser(int userId, int empId) {
		return userDao.deactivateUser(userId, empId);
	}
	
	public boolean activateUser(int userId, int empId) {
		return userDao.activateUser(userId, empId);
	}
	
	public User createAdminUserInAppStart() {
		User user1 = new User();
		user1.setUserName("ADMIN");
		user1.setPassword("admin");
		user1.setIsActive(true);
		user1.setCreatedTs(new Date());
		
		UserRole userRole1 = new UserRole();
		userRole1.setRoleType("GRAMINMART");
		userRole1.setDisplayName("ADMIN");
		userRole1.setName("ROLE_ADMIN");
		
		userRole1 = userRoleDao.save(userRole1);
		
		UserRole userRole2 = new UserRole();
		userRole2.setRoleType("GRAMINMART");
		userRole2.setDisplayName("USER");
		userRole2.setName("ROLE_USER");
		
		userRole2 = userRoleDao.save(userRole2);
		
		UserRole userRole3 = new UserRole();
		userRole3.setRoleType("GRAMINMART");
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
	
	
	/************************** Location service ******************************/
	
	public LocationServed saveLocation(LocationServed locationServed) throws CustomUniqueKeyViolationException {
		// check name is already exists
		if(locationServedDao.findByName(locationServed.getName()) != null) {
			throw new CustomUniqueKeyViolationException("Location is already exists with this name");
		}
		return locationServedDao.save(locationServed);
	}
	
	public void updateLocation(LocationServed locationServed) throws CustomUniqueKeyViolationException, NotExistException {
		// check location existance
		if(locationServedDao.findById(locationServed.getLocationId()) == null) {
			throw new NotExistException("This location doesn't exists");
		}
		
		// check name is already exists
		LocationServed locationServedByName = locationServedDao.findByName(locationServed.getName());
		if(locationServedByName != null) {
			if(locationServedByName.getLocationId() != locationServed.getLocationId()) {
				throw new CustomUniqueKeyViolationException("Location is already exists with this name");
			}
		}
		locationServedDao.update(locationServed);
	}
	
	public boolean activateLocation(int locationId, int userId) throws NotExistException{
		// check location existance
		if(locationServedDao.findById(locationId) == null) {
			throw new NotExistException("This location doesn't exists");
		}
		
		return locationServedDao.activateLocation(locationId, userId);
	}
	
	public boolean deActivateLocation(int locationId, int userId) throws NotExistException {
		// check location existance
		if(locationServedDao.findById(locationId) == null) {
			throw new NotExistException("This location doesn't exists");
		}
		
		return locationServedDao.deactivateLocation(locationId, userId);
	}
	
}
