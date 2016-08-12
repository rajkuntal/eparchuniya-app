package com.eparchuniya.app.dao.inventory;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.inventory.ItemType;

public interface ItemTypeDao extends GenericDoa<ItemType, Integer> {
	
	ItemType findByCode(String code);

}
