package com.eparchuniya.app.dao.employee;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.employee.Employee;

public interface EmployeeDao extends GenericDoa<Employee, Integer> {
	
	Employee findByMobileNumber(Long mobile);

}
