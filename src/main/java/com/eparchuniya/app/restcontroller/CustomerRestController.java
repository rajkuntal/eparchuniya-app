package com.eparchuniya.app.restcontroller;

import java.util.Date;
import java.util.Iterator;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.customer.Customer;
import com.eparchuniya.app.domain.customer.CustomerAddress;
import com.eparchuniya.app.domain.customer.CustomerMobile;
import com.eparchuniya.app.exception.ApiError;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;
import com.eparchuniya.app.exception.ResponseCode;
import com.eparchuniya.app.exception.SuccessResponse;
import com.eparchuniya.app.security.service.LoggedInUserService;
import com.eparchuniya.app.service.CustomerService;

@RestController
@RequestMapping(value = "/customermanagement")
public class CustomerRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired
	private LoggedInUserService loggedInUserService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer) {
		try {
			customer.setBlocked(false);
			customer.setCreatedBy(loggedInUserService.getUser());
			customer.setCreatedTs(new Date());
			CustomerAddress customerAddress = null;
			CustomerMobile customerMobile = null;
			if(customer.getCustomerAddresses() != null) {
				if(!customer.getCustomerAddresses().isEmpty()) {
					customerAddress = customer.getCustomerAddresses().get(0);
					customerAddress.setCreatedBy(loggedInUserService.getUser());
					customerAddress.setCreatedTs(new Date());
				}
			}
			if(customer.getMobileNumbers() != null) {
				if(!customer.getMobileNumbers().isEmpty()) {
					customerMobile = customer.getMobileNumbers().get(0);
					// check mobile number already exists
					if(customerService.isMobileExisting(customerMobile.getMobileNumber())) {
						ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, "mobile already exists");
						return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
					}
					customerMobile.setBlocked(false);
					customerMobile.setCreatedBy(loggedInUserService.getUser());
					customerMobile.setCreatedTs(new Date());
				}
			}
			
			logger.info("Saving new customer :" + customer.getFirstName());
			customerService.addCustomer(customer);
			
			customerAddress.setCustomer(customer);
			logger.info("Saving customer :" + customer.getFirstName() + " Address");
			customerService.addAddress(customerAddress);
			
			customerMobile.setCustomer(customer);
			logger.info("Saving customer :" + customer.getFirstName() + " Mobile");
			customerService.addMobile(customerMobile);
			
			
		} catch (CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new customer : " + customer.getFirstName() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("New customer successfully created :" + customer.getFirstName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Customer successfully created"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer) {
		try {
			customer.setModifiedBy(loggedInUserService.getUser());
			customer.setModifiedTs(new Date());
			logger.info("upidating customer : " + customer.getFirstName());
			customerService.updateCustomer(customer);
		} catch (NotExistException ex) {
			logger.error("error while updating customer : " + customer.getFirstName() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("customer successfully updated :" + customer.getFirstName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Customer successfully updated"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/verify/{customerId}", method = RequestMethod.POST)
	public ResponseEntity<?> verifyCustomer(@PathVariable long customerId) {
		try {
			logger.info("request to make verified customer :" + customerId);
			customerService.verifyCustomer(customerId, loggedInUserService.getUser().getUserId());
		} catch (NotExistException ex) {
			logger.error("error while make verified customer : " + customerId + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("customer successfully verified :" + customerId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Customer successfully verified"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/block/{customerId}", method = RequestMethod.POST)
	public ResponseEntity<?> blockCustomer(@PathVariable long customerId, @RequestBody String comments) {
		try {
			logger.info("request to block customer :" + customerId);
			customerService.blockCustomer(customerId, loggedInUserService.getUser().getUserId(), comments);
		} catch (NotExistException ex) {
			logger.error("error while blocking customer : " + customerId + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("customer successfully blocked :" + customerId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Customer successfully blocked"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/unblock/{customerId}", method = RequestMethod.POST)
	public ResponseEntity<?> unblockCustomer(@PathVariable long customerId, @RequestBody String comments) {
		try {
			logger.info("request to unblock customer :" + customerId);
			customerService.blockCustomer(customerId, loggedInUserService.getUser().getUserId(), comments);
		} catch (NotExistException ex) {
			logger.error("error while unblocking customer : " + customerId + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("customer successfully unblocked :" + customerId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Customer successfully unblocked"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customermobile/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomerMobile(@Valid @RequestBody CustomerMobile customerMobile){
		try{
			customerMobile.setBlocked(false);
			customerMobile.setCreatedBy(loggedInUserService.getUser());
			customerMobile.setCreatedTs(new Date());
			logger.info("saving new customer mobile:" + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId());
			customerService.addMobile(customerMobile);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new customer mobile : " + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("new customer mobile added successfully: " + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Mobile added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customermobile/update", method = RequestMethod.POST)
	public ResponseEntity<?> modifyCustomerMobile(@Valid @RequestBody CustomerMobile customerMobile){
		try{
			customerMobile.setModifiedBy(loggedInUserService.getUser());
			customerMobile.setModifiedTs(new Date());
			logger.info("updating customer mobile:" + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId());
			customerService.updateMobile(customerMobile);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while updating customer mobile : " + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(NotExistException ex) {
			logger.error("error while updating customer mobile : " + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("new customer mobile added successfully: " + customerMobile.getMobileNumber() + " -- customerId :" + customerMobile.getCustomer().getCustomerId());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Mobile updated successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customermobile/verify/{mobileNumber}", method = RequestMethod.POST)
	public ResponseEntity<?> verifyCustomerMobile(@PathVariable long mobileNumber){
		try{
			logger.info("request to verify customer mobile:" + mobileNumber);
			customerService.verifyMobile(mobileNumber, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("error while verifing customer mobile : "+mobileNumber+ " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("Mobile verified successfully: " + mobileNumber);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Mobile verified successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customermobile/block/{mobileNumber}", method = RequestMethod.POST)
	public ResponseEntity<?> blockCustomerMobile(@PathVariable long mobileNumber, @RequestBody String comments){
		try{
			logger.info("request to block customer mobile:" + mobileNumber);
			customerService.blockMobile(mobileNumber, loggedInUserService.getUser().getUserId(), comments);
		} catch(NotExistException ex) {
			logger.error("error while blocking customer mobile : "+mobileNumber+ " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("Mobile blocked successfully: " + mobileNumber);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Mobile blocked successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customermobile/unblock/{mobileNumber}", method = RequestMethod.POST)
	public ResponseEntity<?> unblockCustomerMobile(@PathVariable long mobileNumber, @RequestBody String comments){
		try{
			logger.info("request to unbloking customer mobile:" + mobileNumber);
			customerService.unblockMobile(mobileNumber, loggedInUserService.getUser().getUserId(), comments);
		} catch(NotExistException ex) {
			logger.error("error while unblocking customer mobile : "+mobileNumber+ " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("Mobile unblocked successfully: " + mobileNumber);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Mobile unbloked successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customeraddress/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomerAddress(@Valid @RequestBody CustomerAddress customerAddress){
		try{
			customerAddress.setCreatedBy(loggedInUserService.getUser());
			customerAddress.setCreatedTs(new Date());
			logger.info("saving new customer address:" + customerAddress.getVillageCity() + " -- customerId :" + customerAddress.getCustomer().getCustomerId());
			customerService.addAddress(customerAddress);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new customer address : " + customerAddress.getVillageCity() + " -- customerId :" + customerAddress.getCustomer().getCustomerId() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("new customer address added successfully: " + customerAddress.getAddressId() + " -- customerId :" + customerAddress.getCustomer().getCustomerId());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Address added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customeraddress/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateCustomerAddress(@Valid @RequestBody CustomerAddress customerAddress){
		try{
			customerAddress.setModifiedBy(loggedInUserService.getUser());
			customerAddress.setModifiedTs(new Date());
			logger.info("updating customer address:" + customerAddress.getAddressId() + " -- customerId :" + customerAddress.getCustomer().getCustomerId());
			customerService.updateAddress(customerAddress);
		} catch(NotExistException ex) {
			logger.error("error while updating customer address : " + customerAddress.getAddressId() + " -- customerId :" + customerAddress.getCustomer().getCustomerId() + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("new customer address updating successfully: " + customerAddress.getAddressId() + " -- customerId :" + customerAddress.getCustomer().getCustomerId());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Address updating successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customeraddress/disable/{addressId}", method = RequestMethod.POST)
	public ResponseEntity<?> disableCustomerAddress(@PathVariable long addressId){
		try{
			logger.info("disabling customer address:" + addressId);
			customerService.disableAddress(addressId, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("error while disabling customer address : " + addressId + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("customer address disabled successfully: " + addressId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Address disabled successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customeraddress/enable/{addressId}", method = RequestMethod.POST)
	public ResponseEntity<?> enableCustomerAddress(@PathVariable long addressId){
		try{
			logger.info("enabling customer address:" + addressId);
			customerService.enableAddress(addressId, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("error while enabling customer address : " + addressId + " --> " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("customer address enabled successfully: " + addressId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Address enabled successfully"), HttpStatus.OK);
	}

}
