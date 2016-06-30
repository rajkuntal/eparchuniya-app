package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.Store;

public interface StoreDao {
	
	public void addStore(Store store);
	
	Store findById(int id);

}
