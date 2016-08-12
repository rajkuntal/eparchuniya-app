package com.graminmart.app.service;

import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graminmart.app.dao.customer.CustomerAddressDao;
import com.graminmart.app.dao.customer.CustomerDao;
import com.graminmart.app.dao.customer.CustomerMobileDao;
import com.graminmart.app.domain.customer.Customer;
import com.graminmart.app.domain.customer.CustomerAddress;
import com.graminmart.app.domain.customer.CustomerMobile;
import com.graminmart.app.exception.CustomUniqueKeyViolationException;
import com.graminmart.app.exception.NotExistException;

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
	
	public CustomerMobile addMobile(CustomerMobile customerMobile) throws CustomUniqueKeyViolationException {
		// check if mob number already exists
		if(customerMobileDao.isMobileExisting(customerMobile.getMobileNumber()) != null)
			throw new CustomUniqueKeyViolationException("This mobile number is associated to other customer");
		return customerMobileDao.save(customerMobile);
	}
	
	public void updateMobile(CustomerMobile customerMobile) throws NotExistException, CustomUniqueKeyViolationException {
		// check if mobile entity exists
		if(customerMobileDao.findById(customerMobile.getId()) == null)
			throw new NotExistException("this mobile is not associated to any customer");
		CustomerMobile mobileExists = customerMobileDao.isMobileExisting(customerMobile.getMobileNumber());
		// check if mob number already exists
		if(mobileExists != null)
		{
			if(mobileExists.getId() != customerMobile.getId())
				throw new CustomUniqueKeyViolationException("This mobile number is associated to other customer");
		}
		customerMobileDao.update(customerMobile);
	}

	public boolean verifyMobile(long mobileNumber, int modifiedBy) throws NotExistException{
		// check if mobile entity exists
		if(customerMobileDao.isMobileExisting(mobileNumber) == null)
			throw new NotExistException("this mobile is not associated to any customer");
		return customerMobileDao.verifyMobile(mobileNumber, modifiedBy);
	}

	public boolean blockMobile(long mobileNumber, int modifiedBy, String comments) throws NotExistException{
		// check if mobile entity exists
		if(customerMobileDao.isMobileExisting(mobileNumber) == null)
			throw new NotExistException("this mobile is not associated to any customer");
		return customerMobileDao.blockMobile(mobileNumber, modifiedBy, comments);
	}

	public boolean unblockMobile(long mobileNumber, int modifiedBy, String comments) throws NotExistException{
		// check if mobile entity exists
		if(customerMobileDao.isMobileExisting(mobileNumber) == null)
			throw new NotExistException("this mobile is not associated to any customer");
		return customerMobileDao.unblockMobile(mobileNumber, modifiedBy, comments);
	}
	
	public boolean isMobileExisting(long mobileNumber) {
		// check is mobile number already exists
		if(customerMobileDao.isMobileExisting(mobileNumber) != null)
			return true;
		else
			return false;
	}

	/****************** Address Services *************************************/
	
	public CustomerAddress addAddress(CustomerAddress customerAddress) {
		return customerAddressDao.save(customerAddress);
	}
	
	public void updateAddress(CustomerAddress customerAddress) throws NotExistException {
		// check if address entity exists
		if(customerAddressDao.findById(customerAddress.getAddressId()) == null)
			throw new NotExistException("this Address is not associated to any customer");
		customerAddressDao.update(customerAddress);
	}
	
	public boolean disableAddress(long addressId, int userId)  throws NotExistException {
		// check if address entity exists
		if(customerAddressDao.findById(addressId) == null)
			throw new NotExistException("this Address is not associated to any customer");
		return customerAddressDao.disableAddress(addressId, userId);
	}

	public boolean enableAddress(long addressId, int userId)  throws NotExistException {
		// check if address entity exists
		if(customerAddressDao.findById(addressId) == null)
			throw new NotExistException("this Address is not associated to any customer");
		return customerAddressDao.enableAddress(addressId, userId);
	}

	/****************** Customer Services *************************************/
	
	public Customer addCustomer(Customer customer) throws CustomUniqueKeyViolationException {
		// check if mobile number already exists
		if(customer.getMobileNumbers() != null) {
			if(!customer.getMobileNumbers().isEmpty()) {
				Iterator<CustomerMobile> mobileIterator =  customer.getMobileNumbers().iterator();
				while(mobileIterator.hasNext()){
					CustomerMobile customerMobile = mobileIterator.next();
					if(customerMobileDao.isMobileExisting(customerMobile.getMobileNumber()) != null)
						throw new CustomUniqueKeyViolationException("This mobile number is already exists");
				}
			}
		}
		
		return customerDao.save(customer);
	}

	public void updateCustomer(Customer customer) throws NotExistException, CustomUniqueKeyViolationException {
		// check customer is exists
		if(customerDao.findById(customer.getCustomerId()) == null)
			throw new NotExistException("This customer doesn't exists");
		customerDao.update(customer);
		
	}

	public boolean verifyCustomer(long customerId, int modifiedBy) throws NotExistException {
		// check customer is exists
		if(customerDao.findById(customerId) == null)
			throw new NotExistException("This customer doesn't exists");
		return customerDao.verifyCustomer(customerId, modifiedBy);
	}

	public boolean blockCustomer(long customerId, int modifiedBy, String commetns) throws NotExistException {
		// check customer is exists
		if(customerDao.findById(customerId) == null)
			throw new NotExistException("This customer doesn't exists");
		return customerDao.blockCustomer(customerId, modifiedBy, commetns);
	}

	public boolean unblockCustomer(long customerId, int modifiedBy, String comments)  throws NotExistException {
		// check customer is exists
		if(customerDao.findById(customerId) == null)
			throw new NotExistException("This customer doesn't exists");
		return customerDao.unblockCustomer(customerId, modifiedBy, comments);
	}

}
