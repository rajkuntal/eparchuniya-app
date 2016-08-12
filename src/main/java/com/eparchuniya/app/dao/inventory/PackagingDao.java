package com.eparchuniya.app.dao.inventory;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.inventory.Packaging;

public interface PackagingDao extends GenericDoa<Packaging, Integer>{
	
	boolean enablePackaging(int packagingId, int modifiedBy);
	
	boolean disablePackaging(int packagingId, int modifiedBy);

}
