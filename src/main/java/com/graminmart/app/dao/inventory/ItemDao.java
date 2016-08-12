package com.graminmart.app.dao.inventory;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.inventory.Item;
import com.graminmart.app.domain.inventory.ItemType;

public interface ItemDao extends GenericDoa<Item, Integer>{
	
	Item findByCode(String code);
	
	int countByTypeId(ItemType itemType);

}
