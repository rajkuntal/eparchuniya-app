package com.graminmart.app.service;

import com.graminmart.app.domain.employee.Designation;
import com.graminmart.app.domain.employee.Employee;
import com.graminmart.app.exception.CustomUniqueKeyViolationException;
import com.graminmart.app.exception.NotExistException;

public interface EmployeeService {
	
	/***************************** Employee Designation Service **********************/
	
	Designation saveDesignation(Designation designation) throws CustomUniqueKeyViolationException;
	
	void updateDesignation(Designation designation) throws CustomUniqueKeyViolationException, NotExistException;
	
	/***************************** Employee Service **********************/
	
	Employee saveEmployee(Employee employee) throws CustomUniqueKeyViolationException;
	
	void updateEmployee(Employee employee) throws CustomUniqueKeyViolationException, NotExistException;

}
