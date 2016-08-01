package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.CustomerAddress;

public interface CustomerAddressDao extends GenericDoa<CustomerAddress, Integer> {

	boolean disableAddress(int addressId);
	
	boolean enableAddress(int addressId);
}
