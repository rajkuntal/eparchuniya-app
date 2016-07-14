package com.eparchuniya.app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("genericDao")
public abstract class GenericDaoImpl<T extends Serializable, K> implements GenericDoa<T, K> {
	
	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }
	
	public T save(T entity) {
		this.em.persist(entity);
		return entity;
	}
	
    public void delete(T entity) {
        this.em.remove(entity);
    }

    public T findById(K id) {
        return (T) this.em.find(type, id);
    }

    public void update(T entity) {
        this.em.merge(entity); 
    }
    
    public long countAll() {
    	StringBuffer queryString = new StringBuffer("SELECT COUNT(o) FROM ");
    	queryString.append(this.type.getSimpleName()).append(" o ");
    	
    	Query query = em.createQuery(queryString.toString());
    	return (Long) query.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	
    	StringBuffer queryString = new StringBuffer("SELECT o FROM ");
    	queryString.append(this.type.getSimpleName()).append(" o ");
    	
    	Query query = em.createQuery(queryString.toString());
    	return query.getResultList();
    }
}
