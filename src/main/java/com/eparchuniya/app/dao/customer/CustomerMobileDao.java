package com.eparchuniya.app.dao.customer;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.customer.CustomerMobile;

public interface CustomerMobileDao extends GenericDoa<CustomerMobile, Long> {
	
	boolean verifyMobile(long mobileNumber, int modifiedBy);
	
	boolean blockMobile(long mobileNumber, int modifiedBy, String comments);
	
	boolean unblockMobile(long mobileNumber, int modifiedBy, String comments);
	
	CustomerMobile isMobileExisting(long mobileNumber);

}
