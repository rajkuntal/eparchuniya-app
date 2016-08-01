package com.eparchuniya.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.CustomerMobile;

@Repository("customerMobileDao")
public class CustomerMobileDaoImpl extends GenericDaoImpl<CustomerMobile, Long> implements CustomerMobileDao {

	@PersistenceContext
	private EntityManager em;
	
	public boolean verifyMobile(long mobileNumber) {
		em.createNativeQuery("UPDATE cust_mobile SET verified = 1 WHERE mobile_number = ?1")
		.setParameter(1, mobileNumber)
		.executeUpdate();
		return true;
	}

	public boolean blockMobile(long mobileNumber) {
		em.createNativeQuery("UPDATE cust_mobile SET blocked = 1 WHERE mobile_number = ?1")
		.setParameter(1, mobileNumber)
		.executeUpdate();
		return true;
	}

	public boolean unblockMobile(long mobileNumber) {
		em.createNativeQuery("UPDATE cust_mobile SET blocked = 0 WHERE mobile_number = ?1")
		.setParameter(1, mobileNumber)
		.executeUpdate();
		return true;
	}

}
