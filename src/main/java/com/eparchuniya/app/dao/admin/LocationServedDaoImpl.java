package com.eparchuniya.app.dao.admin;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.admin.LocationServed;

@Repository("locationServedDao")
public class LocationServedDaoImpl extends GenericDaoImpl<LocationServed, Integer>implements LocationServedDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<LocationServed> findByStoreId(int storeId) {
		List<LocationServed> locations = em.createQuery("SELECT l FROM LocationServed l WHERE l.Store.storeId = ?1")
				.setParameter(1, storeId).getResultList();
		if (!locations.isEmpty())
			return locations;
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public LocationServed findById(int locationId) {
		List<LocationServed> locations = em.createQuery("SELECT l FROM LocationServed l WHERE l.locationId = ?1")
				.setParameter(1, locationId).getResultList();
		if (!locations.isEmpty())
			return locations.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public LocationServed findByName(String name) {
		List<LocationServed> locations = em.createQuery("SELECT l FROM LocationServed l WHERE l.name = ?1")
				.setParameter(1, name).getResultList();
		if (!locations.isEmpty())
			return locations.get(0);
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
