package com.eparchuniya.app.dao.inventory;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.inventory.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements CategoryDao {

	@SuppressWarnings("unchecked")
	public Category findByCode(String code) {
		List<Category> categories = em.createQuery("SELECT c FROM Category c WHERE c.code = ?1")
		.setParameter(1, code)
		.getResultList();
		if(!categories.isEmpty())
			return categories.get(0);
		else
			return null;
	}

}
