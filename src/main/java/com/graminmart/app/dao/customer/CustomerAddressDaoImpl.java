package com.graminmart.app.dao.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.graminmart.app.dao.generic.GenericDaoImpl;
import com.graminmart.app.domain.customer.CustomerAddress;

@Repository("customerAddressDao")
public class CustomerAddressDaoImpl extends GenericDaoImpl<CustomerAddress, Long> implements CustomerAddressDao {

	@PersistenceContext
	private EntityManager em;
	
	public boolean disableAddress(long addressId, int userId) {
		em.createNativeQuery("UPDATE cust_address SET enabled = 0, modified_by=?0, modified_at=NOW() WHERE address_id = ?1")
		.setParameter(0, userId)
		.setParameter(1, addressId)
		.executeUpdate();
		return true;
	}

	public boolean enableAddress(long addressId, int userId) {
		em.createNativeQuery("UPDATE cust_address SET enabled = 1, modified_by=?0, modified_at=NOW()  WHERE address_id = ?1")
		.setParameter(0, userId)
		.setParameter(1, addressId)
		.executeUpdate();
		return true;
	}

}
