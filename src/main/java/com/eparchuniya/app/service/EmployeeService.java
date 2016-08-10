package com.eparchuniya.app.service;

import com.eparchuniya.app.domain.employee.Designation;
import com.eparchuniya.app.domain.employee.Employee;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;

public interface EmployeeService {
	
	/***************************** Employee Designation Service **********************/
	
	Designation saveDesignation(Designation designation) throws CustomUniqueKeyViolationException;
	
	void updateDesignation(Designation designation) throws CustomUniqueKeyViolationException, NotExistException;
	
	/***************************** Employee Service **********************/
	
	Employee saveEmployee(Employee employee) throws CustomUniqueKeyViolationException;
	
	void updateEmployee(Employee employee) throws CustomUniqueKeyViolationException, NotExistException;

}
