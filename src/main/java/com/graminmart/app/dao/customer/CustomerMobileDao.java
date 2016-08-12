package com.graminmart.app.dao.customer;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.customer.CustomerMobile;

public interface CustomerMobileDao extends GenericDoa<CustomerMobile, Long> {
	
	boolean verifyMobile(long mobileNumber, int modifiedBy);
	
	boolean blockMobile(long mobileNumber, int modifiedBy, String comments);
	
	boolean unblockMobile(long mobileNumber, int modifiedBy, String comments);
	
	CustomerMobile isMobileExisting(long mobileNumber);

}
