package com.eparchuniya.app.dao.inventory;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.inventory.Item;
import com.eparchuniya.app.domain.inventory.ItemType;

public interface ItemDao extends GenericDoa<Item, Integer>{
	
	Item findByCode(String code);
	
	int countByTypeId(ItemType itemType);

}
