package com.graminmart.app.dao.admin;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.admin.Store;

public interface StoreDao extends GenericDoa<Store, Integer>{
	
	Store findByCode(String code);
	
	Store findByName(String name);
	
	boolean deactivateStore(int storeId);
	
	boolean activateStore(int storeId);
	
	boolean isCodeExisting(String code);
	
	boolean isNameExisting(String name);
}
