package com.eparchuniya.app.service;

import com.eparchuniya.app.domain.Designation;
import com.eparchuniya.app.domain.Employee;

public interface EmployeeService {
	
	/***************************** Employee Designation Service **********************/
	
	Designation saveDesignation(Designation designation);
	
	void updateDesignation(Designation designation);
	
	/***************************** Employee Service **********************/
	
	Employee saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);

}
