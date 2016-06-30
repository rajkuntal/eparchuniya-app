package com.eparchuniya.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eparchuniya.app.domain.Store;

@Transactional
@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void addStore(Store store) {
		sessionFactory.getCurrentSession().save(store);
	}

	public Store findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
