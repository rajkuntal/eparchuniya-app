package com.graminmart.app.dao.generic;

import java.util.List;

import com.graminmart.app.domain.base.BaseDomain;

public interface GenericDoa<T extends BaseDomain, K> {
	
	T save(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	T findById(K id);
	
	long countAll();
	
	List<T> findAll();
}
