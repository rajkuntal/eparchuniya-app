package com.eparchuniya.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.Store;

@Repository("storeDao")
public class StoreDaoImpl extends GenericDaoImpl<Store, Integer> implements StoreDao {
	
//	@PersistenceContext
//	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Store findByCode(String code) {
		List<Store> stores = em.createQuery("SELECT s FROM Store s WHERE s.code LIKE ?0")
				.setParameter(0, "%"+code+"%")
				.getResultList();
		if (!stores.isEmpty())
			return stores.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public Store findByName(String name) {
		List<Store> stores = em.createQuery("SELECT s FROM Store s WHERE s.code LIKE ?0")
				.setParameter(0, "%"+name+"%")
				.getResultList();
		if (!stores.isEmpty())
			return stores.get(0);
		else
			return null;
	}

	public boolean deactivateStore(int storeId) {
		em.createNativeQuery("UPDATE admin_store SET is_active = 0 WHERE store_id = ?1")
				.setParameter(1, storeId)
				.executeUpdate();
			return true;
	}

	public boolean activateStore(int storeId) {
		em.createNativeQuery("UPDATE admin_store SET is_active = 1, start_date = 1? WHERE store_id = ?2")
		.setParameter(1, new Date())
		.setParameter(2, storeId)
		.executeUpdate();
	return true;
	}

	@SuppressWarnings("unchecked")
	public boolean isCodeExisting(String code) {
		List<Store> stores = em.createQuery("SELECT s FROM Store s WHERE s.code = ?1")
				.setParameter(1, code)
				.getResultList();
		if (!stores.isEmpty())
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	public boolean isNameExisting(String name) {
		List<Store> stores = em.createQuery("SELECT s FROM Store s WHERE s.name = ?1")
				.setParameter(1, name)
				.getResultList();
		if (!stores.isEmpty())
			return true;
		else
			return false;
	}

}
