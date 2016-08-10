package com.eparchuniya.app.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.eparchuniya.app.domain.admin.LocationServed;
import com.eparchuniya.app.domain.admin.Store;
import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.domain.admin.UserRole;
import com.eparchuniya.app.domain.employee.Designation;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;

public interface AdminService {
	
	Store saveStore(Store store) throws CustomUniqueKeyViolationException;
	
	void updateStore(Store store) throws NotExistException;
	
	void deleteStore(Store store);
	
	Store findStoreByStoreId(int storeId);
	
	Store findStoreByCode(String code);
	
	Store findStoreByName(String name);
	
	long countAllStores();
	
	List<Store> getAllStores();
	
	boolean deactivateStore(int storeId) throws NotExistException;
	
	boolean activateStore(int storeId) throws NotExistException;
	
	
	/***************************** User Service **********************/
	
	User saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User findUserByUserId(int userId);
	
	User findUserByName(String userName);
	
	long countAllUsers();
	
	List<User> getAllUsers();
	
	boolean deactivateUser(int userId, int empId);
	
	boolean activateUser(int userId, int empId);
	
	User createAdminUserInAppStart();
	
/***************************** User Role Service **********************/
	
	UserRole saveUserRole(UserRole userRole);
	
	void updateUserRole(UserRole userRole);
	
	void deleteUserRole(UserRole userRole);
	
	UserRole findUserByUserRoleId(int userRoleId);
	
	long countAllUserRoles();
	
	List<UserRole> getAllUserRoles();
	
	/***************************** Location Service **********************/
	
	LocationServed saveLocation(LocationServed locationServed) throws CustomUniqueKeyViolationException;
	
	void updateLocation(LocationServed locationServed) throws CustomUniqueKeyViolationException, NotExistException;
	
	boolean activateLocation(int locationId, int userId) throws NotExistException;
	
	boolean deActivateLocation(int locationId, int userId) throws NotExistException;

}
