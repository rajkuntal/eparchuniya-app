package com.eparchuniya.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.CustomerAddress;

@Repository("customerAddressDao")
public class CustomerAddressDaoImpl extends GenericDaoImpl<CustomerAddress, Integer> implements CustomerAddressDao {

	@PersistenceContext
	private EntityManager em;
	
	public boolean disableAddress(int addressId) {
		em.createNativeQuery("UPDATE cust_address SET enabled = 0 WHERE address_id = ?1")
		.setParameter(1, addressId)
		.executeUpdate();
		return true;
	}

	public boolean enableAddress(int addressId) {
		em.createNativeQuery("UPDATE cust_address SET enabled = 1 WHERE address_id = ?1")
		.setParameter(1, addressId)
		.executeUpdate();
		return true;
	}

}
