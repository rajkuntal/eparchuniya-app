package com.eparchuniya.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Long> implements CustomerDao{

	@PersistenceContext
	private EntityManager em;
	
	public boolean verifyCustomer(int customerId) {
		em.createNativeQuery("UPDATE cust_customer SET verified = 1 WHERE customer_id = ?1")
		.setParameter(1, customerId)
		.executeUpdate();
		return true;
	}

	public boolean blockCustomer(int customerId) {
		em.createNativeQuery("UPDATE cust_customer SET blocked = 1 WHERE customer_id = ?1")
		.setParameter(1, customerId)
		.executeUpdate();
		return true;
	}

	public boolean unblockCustomer(int customerId) {
		em.createNativeQuery("UPDATE cust_customer SET blocked = 0 WHERE customer_id = ?1")
		.setParameter(1, customerId)
		.executeUpdate();
		return true;
	}

}
