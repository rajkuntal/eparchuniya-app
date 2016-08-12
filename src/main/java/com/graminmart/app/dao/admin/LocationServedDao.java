package com.graminmart.app.dao.admin;

import java.util.List;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.admin.LocationServed;

public interface LocationServedDao extends GenericDoa<LocationServed, Integer> {
	
	List<LocationServed> findByStoreId(int storeId);
	
	boolean deactivateLocation(int locationId, int userId);
	
	boolean activateLocation(int locationId, int userId);
	
	LocationServed findById(int id);
	
	LocationServed findByName(String name);

}
