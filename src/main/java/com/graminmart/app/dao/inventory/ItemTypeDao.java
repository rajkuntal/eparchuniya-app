package com.graminmart.app.dao.inventory;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.inventory.ItemType;

public interface ItemTypeDao extends GenericDoa<ItemType, Integer> {
	
	ItemType findByCode(String code);

}
