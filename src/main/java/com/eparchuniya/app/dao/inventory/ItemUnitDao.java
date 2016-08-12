package com.eparchuniya.app.dao.inventory;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.inventory.ItemUnit;

public interface ItemUnitDao extends GenericDoa<ItemUnit, Integer>{
	
	ItemUnit findByCode(String code);

}
