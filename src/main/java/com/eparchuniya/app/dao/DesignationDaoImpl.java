package com.eparchuniya.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eparchuniya.app.domain.Designation;
import com.eparchuniya.app.domain.Store;

@Transactional
@Repository("designationDao")
public class DesignationDaoImpl implements DesignationDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addDesignation(Designation designation) {
		
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(new java.util.Date().getTime());
		designation.setCreatedBY(1);
		designation.setModifiedBy(1);
		designation.setCreatedTs(timeStamp);
		designation.setModifiedTs(timeStamp);
		
		sessionFactory.getCurrentSession().save(designation);
		
	}

	public Designation findById(int id) {
		
		return (Designation) sessionFactory.getCurrentSession().get(Designation.class, id);
	}

}
