package com.graminmart.app.dao.employee;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.employee.Employee;

public interface EmployeeDao extends GenericDoa<Employee, Integer> {
	
	Employee findByMobileNumber(Long mobile);

}
