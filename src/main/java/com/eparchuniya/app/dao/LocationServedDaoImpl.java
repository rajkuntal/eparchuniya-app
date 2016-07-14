package com.eparchuniya.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eparchuniya.app.domain.LocationServed;

public class LocationServedDaoImpl extends GenericDaoImpl<LocationServed, Integer> implements LocationServedDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<LocationServed> findByStoreId(int storeId) {	
		List<LocationServed> locations = em.createQuery("SELECT s FROM LocationServed WHERE s.Store.storeId = ?1")
										.setParameter(1, storeId)
										.getResultList();
		
		if(locations != null)
			return locations;
		else
			return null;
	}
	

}
