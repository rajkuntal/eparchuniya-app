package com.eparchuniya.app.dao.customer;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.customer.CustomerAddress;

public interface CustomerAddressDao extends GenericDoa<CustomerAddress, Long> {

	boolean disableAddress(long addressId, int userId);
	
	boolean enableAddress(long addressId, int userId);
}
