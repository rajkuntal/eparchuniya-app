package com.eparchuniya.app.dao.customer;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.customer.Customer;

public interface CustomerDao extends GenericDoa<Customer, Long> {
	
	boolean verifyCustomer(long customerId, int modifiedBy);
	
	boolean blockCustomer(long customerId, int modifiedBy, String comments);
	
	boolean unblockCustomer(long customerId, int modifiedBy, String comments);

}
