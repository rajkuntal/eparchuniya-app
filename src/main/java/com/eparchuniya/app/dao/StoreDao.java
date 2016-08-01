package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.Store;

public interface StoreDao extends GenericDoa<Store, Integer>{
	
	Store findByCode(String code);
	
	Store findByName(String name);
	
	boolean deactivateStore(int storeId);
	
	boolean activateStore(int storeId);
	
	boolean isCodeExisting(String code);
	
	boolean isNameExisting(String name);
}
