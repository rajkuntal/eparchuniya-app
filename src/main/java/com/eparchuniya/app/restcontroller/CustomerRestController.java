package com.eparchuniya.app.restcontroller;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.Customer;
import com.eparchuniya.app.domain.CustomerAddress;
import com.eparchuniya.app.security.service.LoggedInUserService;
import com.eparchuniya.app.service.CustomerService;

@RestController
@RequestMapping(value = "/customermanagement")
public class CustomerRestController {
	
	@Autowired
	private LoggedInUserService loggedInUserService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		
		customer.setBlocked(false);
		customer.setCreatedBy(loggedInUserService.getUser());
		customer.setCreatedTs(new Date());
		
		Iterator<CustomerAddress> iterator =  customer.getCustomerAddresses().iterator();
		while(iterator.hasNext()){
			CustomerAddress customerAddress = iterator.next();
			customerAddress.setCreatedBy(loggedInUserService.getUser());
			customerAddress.setCreatedTs(new Date());
		}
		return customerService.addCustomer(customer);
	}

}
