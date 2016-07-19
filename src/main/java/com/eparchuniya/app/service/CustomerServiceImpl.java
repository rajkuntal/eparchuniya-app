package com.eparchuniya.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eparchuniya.app.dao.CustomerAddressDao;
import com.eparchuniya.app.dao.CustomerDao;
import com.eparchuniya.app.dao.CustomerMobileDao;
import com.eparchuniya.app.domain.Customer;
import com.eparchuniya.app.domain.CustomerAddress;
import com.eparchuniya.app.domain.CustomerMobile;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMobileDao customerMobileDao;
	
	@Autowired 
	private CustomerAddressDao customerAddressDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	/****************** Mobile Services *************************************/
	
	public CustomerMobile addMobile(CustomerMobile mobileNumber) {
		return customerMobileDao.save(mobileNumber);
	}

	public boolean verifyMobile(long mobileNumber) {
		return customerMobileDao.verifyMobile(mobileNumber);
	}

	public boolean blockMobile(long mobileNumber) {
		return customerMobileDao.blockMobile(mobileNumber);
	}

	public boolean unblockMobile(long mobileNumber) {
		return customerMobileDao.unblockMobile(mobileNumber);
	}

	/****************** Address Services *************************************/
	
	public CustomerAddress addAddress(CustomerAddress customerAddress) {
		return customerAddressDao.save(customerAddress);
	}
	
	public boolean disableAddress(int addressId) {
		return customerAddressDao.disableAddress(addressId);
	}

	public boolean enableAddress(int addressId) {
		return customerAddressDao.enableAddress(addressId);
	}

	/****************** Customer Services *************************************/
	
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
		
	}

	public boolean verifyCustomer(int customerId) {
		return customerDao.verifyCustomer(customerId);
	}

	public boolean blockCustomer(int customerId) {
		return customerDao.blockCustomer(customerId);
	}

	public boolean unblockCustomer(int customerId) {
		return customerDao.unblockCustomer(customerId);
	}

}
