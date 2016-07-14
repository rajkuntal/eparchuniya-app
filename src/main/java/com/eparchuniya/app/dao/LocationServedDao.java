package com.eparchuniya.app.dao;

import java.util.List;

import com.eparchuniya.app.domain.LocationServed;

public interface LocationServedDao extends GenericDoa<LocationServed, Integer> {
	
	List<LocationServed> findByStoreId(int storeId);

}