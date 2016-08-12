package com.graminmart.app.dao.inventory;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.inventory.ItemUnit;

public interface ItemUnitDao extends GenericDoa<ItemUnit, Integer>{
	
	ItemUnit findByCode(String code);

}
