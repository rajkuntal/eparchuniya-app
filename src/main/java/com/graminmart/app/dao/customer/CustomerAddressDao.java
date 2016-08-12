package com.graminmart.app.dao.customer;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.customer.CustomerAddress;

public interface CustomerAddressDao extends GenericDoa<CustomerAddress, Long> {

	boolean disableAddress(long addressId, int userId);
	
	boolean enableAddress(long addressId, int userId);
}
