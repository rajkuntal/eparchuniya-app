package com.eparchuniya.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eparchuniya.app.dao.DesignationDao;
import com.eparchuniya.app.dao.EmployeeDao;
import com.eparchuniya.app.domain.Designation;
import com.eparchuniya.app.domain.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private DesignationDao designationDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	/***************************** Employee Designation Service **********************/
	
	public Designation saveDesignation(Designation designation) {
		return designationDao.save(designation);
	}
	
	public void updateDesignation(Designation designation) {
		designationDao.update(designation);
	}
	
	/***************************** Employee Service **********************/

	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.update(employee);
	}

}
