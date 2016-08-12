package com.graminmart.app.dao.customer;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.graminmart.app.dao.generic.GenericDaoImpl;
import com.graminmart.app.domain.customer.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Long> implements CustomerDao{

	@PersistenceContext
	private EntityManager em;
	
	public boolean verifyCustomer(long customerId, int modifiedBy) {
		String query = "UPDATE cust_customer SET verified = 1, modified_by = ?1, modified_at = ?2 WHERE customer_id = ?3";
		em.createNativeQuery(query)
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, customerId)
		.executeUpdate();
		return true;
	}

	public boolean blockCustomer(long customerId, int modifiedBy, String comments) {
		em.createNativeQuery("UPDATE cust_customer SET blocked = 1, block_comments = ?0, modified_by = ?1, modified_at = ?2 WHERE customer_id = ?3")
		.setParameter(0, comments)
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, customerId)
		.executeUpdate();
		return true;
	}

	public boolean unblockCustomer(long customerId, int modifiedBy, String comments) {
		em.createNativeQuery("UPDATE cust_customer SET blocked = 0, block_comments = ?0, modified_by = ?1, modified_at = ?2 WHERE customer_id = ?3")
		.setParameter(0, comments)
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, customerId)
		.executeUpdate();
		return true;
	}

}
