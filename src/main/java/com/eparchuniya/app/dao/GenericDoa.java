package com.eparchuniya.app.dao;

import java.util.List;

import com.eparchuniya.app.domain.basedomain.BaseDomain;

public interface GenericDoa<T extends BaseDomain, K> {
	
	T save(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	T findById(K id);
	
	long countAll();
	
	List<T> findAll();
}
