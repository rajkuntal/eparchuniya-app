package com.eparchuniya.app.service;

import java.util.List;

import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.domain.UserRole;

public interface AdminService {
	
	Store saveStore(Store store);
	
	void updateStore(Store store);
	
	void deleteStore(Store store);
	
	Store findStoreByStoreId(int storeId);
	
	Store findStoreByCode(String code);
	
	Store findStoreByName(String name);
	
	long countAllStores();
	
	List<Store> getAllStores();
	
	/***************************** User Service **********************/
	
	User saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User findUserByUserId(int userId);
	
	User findUserByName(String userName);
	
	long countAllUsers();
	
	List<User> getAllUsers();
	
/***************************** User Role Service **********************/
	
	UserRole saveUserRole(UserRole userRole);
	
	void updateUserRole(UserRole userRole);
	
	void deleteUserRole(UserRole userRole);
	
	UserRole findUserByUserRoleId(int userRoleId);
	
	long countAllUserRoles();
	
	List<UserRole> getAllUserRoles();

}
