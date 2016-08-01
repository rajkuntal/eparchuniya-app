package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.Customer;

public interface CustomerDao extends GenericDoa<Customer, Long> {
	
	boolean verifyCustomer(int customerId);
	
	boolean blockCustomer(int customerId);
	
	boolean unblockCustomer(int customerId);

}
