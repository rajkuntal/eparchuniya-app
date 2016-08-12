package com.eparchuniya.app.dao.inventory;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.inventory.Category;

public interface CategoryDao extends GenericDoa<Category, Integer>{
	
	Category findByCode(String code);

}
