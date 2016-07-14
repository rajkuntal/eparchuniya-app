package com.eparchuniya.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.Store;

@Repository("storeDao")
public class StoreDaoImpl extends GenericDaoImpl<Store, Integer> implements StoreDao {
	
	private EntityManager em;

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

}
