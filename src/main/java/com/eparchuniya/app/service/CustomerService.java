package com.eparchuniya.app.service;

import com.eparchuniya.app.domain.customer.Customer;
import com.eparchuniya.app.domain.customer.CustomerAddress;
import com.eparchuniya.app.domain.customer.CustomerMobile;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;

public interface CustomerService {
	
	/****************** Mobile Services *************************************/
	
	CustomerMobile addMobile(CustomerMobile customerMobile) throws CustomUniqueKeyViolationException;
	
	void updateMobile(CustomerMobile customerMobile) throws NotExistException, CustomUniqueKeyViolationException;
	
	boolean verifyMobile(long mobileNumber, int modifiedBy) throws NotExistException;
	
	boolean blockMobile(long mobileNumber, int modifiedBy, String comments) throws NotExistException;
	
	boolean unblockMobile(long mobileNumber, int modifiedBy, String comments) throws NotExistException;
	
	boolean isMobileExisting(long mobileNumber);
	
	/****************** Address Services *************************************/
	
	CustomerAddress addAddress(CustomerAddress customerAddress);
	
	void updateAddress(CustomerAddress customerAddress) throws NotExistException;
	
	boolean disableAddress(long addressId, int userId) throws NotExistException;
	
	boolean enableAddress(long addressId, int userId) throws NotExistException;
	
	/****************** Customer Services *************************************/
	
	Customer addCustomer(Customer customer) throws CustomUniqueKeyViolationException;
	
	void updateCustomer(Customer customer) throws NotExistException, CustomUniqueKeyViolationException;
	
	boolean verifyCustomer(long customerId, int modifiedBy) throws NotExistException;
	
	boolean blockCustomer(long customerId, int modifiedBy, String comments) throws NotExistException;
	
	boolean unblockCustomer(long customerId, int modifiedBy, String comments) throws NotExistException;

}
