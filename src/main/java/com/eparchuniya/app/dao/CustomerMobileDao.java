package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.CustomerMobile;

public interface CustomerMobileDao extends GenericDoa<CustomerMobile, Long> {
	
	boolean verifyMobile(long mobileNumber);
	
	boolean blockMobile(long mobileNumber);
	
	boolean unblockMobile(long mobileNumber);

}
