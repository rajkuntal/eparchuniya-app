package com.eparchuniya.app.service;

import java.util.List;

import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.domain.UserRole;

public interface AdminService {
	
	Store saveStore(Store store) throws Exception;
	
	void updateStore(Store store);
	
	void deleteStore(Store store);
	
	Store findStoreByStoreId(int storeId);
	
	Store findStoreByCode(String code);
	
	Store findStoreByName(String name);
	
	long countAllStores();
	
	List<Store> getAllStores();
	
	boolean deactivateStore(int storeId);
	
	boolean activateStore(int storeId);
	
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

}
