package com.graminmart.app.dao.inventory;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.inventory.Category;

public interface CategoryDao extends GenericDoa<Category, Integer>{
	
	Category findByCode(String code);

}
