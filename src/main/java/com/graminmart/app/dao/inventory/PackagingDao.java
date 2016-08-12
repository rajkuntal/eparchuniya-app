package com.graminmart.app.dao.inventory;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.inventory.Packaging;

public interface PackagingDao extends GenericDoa<Packaging, Integer>{
	
	boolean enablePackaging(int packagingId, int modifiedBy);
	
	boolean disablePackaging(int packagingId, int modifiedBy);

}
