package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.EmployeeAddress;

public interface EmployeeAddressDao {
	
	void addEmployeeAddress(EmployeeAddress employeeAddress);
	
	public EmployeeAddress findById(int id);

}
