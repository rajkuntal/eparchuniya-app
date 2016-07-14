package com.eparchuniya.app.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDoa<T extends Serializable, K> {
	
	T save(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	T findById(K id);
	
	long countAll();
	
	List<T> findAll();
}
