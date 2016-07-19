package com.eparchuniya.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eparchuniya.app.domain.LocationServed;

public class LocationServedDaoImpl extends GenericDaoImpl<LocationServed, Integer>implements LocationServedDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<LocationServed> findByStoreId(int storeId) {
		List<LocationServed> locations = em.createQuery("SELECT s FROM LocationServed WHERE s.Store.storeId = ?1")
				.setParameter(1, storeId).getResultList();
		if (locations != null)
			return locations;
		else
			return null;
	}

	public boolean deactivateLocation(int locationId, int userId) {
		em.createNativeQuery("UPDATE admin_location_served SET is_active = 0, modified_by = ?1, modified_at = ?2 WHERE location_id = ?3")
		.setParameter(1, userId)
		.setParameter(2, new Date())
		.setParameter(3, locationId)
		.executeUpdate();
		return true;

	}
	
	public boolean activateLocation(int locationId, int userId) {
		em.createNativeQuery("UPDATE admin_location_served SET is_active = 1, modified_by = ?1, modified_at = ?2 WHERE location_id = ?3")
		.setParameter(1, userId)
		.setParameter(2, new Date())
		.setParameter(3, locationId)
		.executeUpdate();
		return true;

	}

}
