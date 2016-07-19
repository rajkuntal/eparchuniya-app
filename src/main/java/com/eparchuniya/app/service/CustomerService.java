package com.eparchuniya.app.service;

import com.eparchuniya.app.domain.Customer;
import com.eparchuniya.app.domain.CustomerAddress;
import com.eparchuniya.app.domain.CustomerMobile;

public interface CustomerService {
	
	/****************** Mobile Services *************************************/
	
	CustomerMobile addMobile(CustomerMobile mobileNumber);
	
	boolean verifyMobile(long mobileNumber);
	
	boolean blockMobile(long mobileNumber);
	
	boolean unblockMobile(long mobileNumber);
	
	/****************** Address Services *************************************/
	
	CustomerAddress addAddress(CustomerAddress customerAddress);
	
	boolean disableAddress(int addressId);
	
	boolean enableAddress(int addressId);
	
	/****************** Customer Services *************************************/
	
	Customer addCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	boolean verifyCustomer(int customerId);
	
	boolean blockCustomer(int customerId);
	
	boolean unblockCustomer(int customerId);

}
