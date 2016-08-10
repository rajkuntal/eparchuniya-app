package com.eparchuniya.app.dao.customer;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.customer.CustomerMobile;

@Repository("customerMobileDao")
public class CustomerMobileDaoImpl extends GenericDaoImpl<CustomerMobile, Long> implements CustomerMobileDao {

	@PersistenceContext
	private EntityManager em;
	
	public boolean verifyMobile(long mobileNumber, int modifiedBy) {
		em.createNativeQuery("UPDATE cust_mobile SET verified = 1, modified_by = ?1, modified_at = ?2 WHERE mobile_number = ?3")
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, mobileNumber)
		.executeUpdate();
		return true;
	}

	public boolean blockMobile(long mobileNumber, int modifiedBy, String comments) {
		em.createNativeQuery("UPDATE cust_mobile SET blocked = 1, modified_by = ?1, modified_at = ?2, block_comments = ?4 WHERE mobile_number = ?3")
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, mobileNumber)
		.setParameter(4, comments)
		.executeUpdate();
		return true;
	}

	public boolean unblockMobile(long mobileNumber, int modifiedBy, String comments) {
		em.createNativeQuery("UPDATE cust_mobile SET blocked = 0, modified_by = ?1, modified_at = ?2, block_comments = ?4 WHERE mobile_number = ?3")
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, mobileNumber)
		.setParameter(4, comments)
		.executeUpdate();
		return true;
	}

	@SuppressWarnings("unchecked")
	public CustomerMobile isMobileExisting(long mobileNumber) {
		List<CustomerMobile> mobiles = em.createQuery("SELECT m FROM CustomerMobile m WHERE m.mobileNumber = ?1")
		.setParameter(1, mobileNumber)
		.getResultList();
		if(!mobiles.isEmpty())
			return mobiles.get(0);
		else
			return null;
	}

}
