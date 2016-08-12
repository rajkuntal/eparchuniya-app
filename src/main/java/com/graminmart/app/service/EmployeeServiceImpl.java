package com.graminmart.app.service;

import java.security.acl.NotOwnerException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graminmart.app.dao.employee.DesignationDao;
import com.graminmart.app.dao.employee.EmployeeDao;
import com.graminmart.app.domain.employee.Designation;
import com.graminmart.app.domain.employee.Employee;
import com.graminmart.app.exception.CustomUniqueKeyViolationException;
import com.graminmart.app.exception.NotExistException;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private DesignationDao designationDao;
	
	@Autowired
	private EmployeeDao employeeDao;


	/***************************** Emp Designation Service **********************/
	
	public Designation saveDesignation(Designation designation) throws CustomUniqueKeyViolationException {
		// check if name already exists
		if(designationDao.findByName(designation.getName()) !=null)
			throw new CustomUniqueKeyViolationException("Designation already exists with same name");
		return designationDao.save(designation);
	}
	
	public void updateDesignation(Designation designation) throws CustomUniqueKeyViolationException, NotExistException {
		// check if designation exists
		if(designationDao.findById(designation.getDesignationId()) == null)
			throw new NotExistException("This designation doesn't exists");
		Designation designationByName = designationDao.findByName(designation.getName());
		// check if name already exists
		if(designationByName !=null){
			if(designationByName.getDesignationId() != designation.getDesignationId())
				throw new CustomUniqueKeyViolationException("Designation already exists with same name");
		}
			
		designationDao.update(designation);
	}
	
	/***************************** Employee Service **********************/

	public Employee saveEmployee(Employee employee) throws CustomUniqueKeyViolationException {
		// check mobile number is unique
		if(employeeDao.findByMobileNumber(employee.getMobileNumber()) != null)
			throw new CustomUniqueKeyViolationException("This mobile number is already exists please provide new mobile number");
		return employeeDao.save(employee);
	}

	public void updateEmployee(Employee employee) throws CustomUniqueKeyViolationException, NotExistException {
		// check employee is exists
		if(employeeDao.findById(employee.getEmployeeId()) == null)
			throw new NotExistException("This employee doesn't exists");
		Employee employeeByMobile = employeeDao.findByMobileNumber(employee.getMobileNumber());
		// check mobile number is unique
		if(employeeByMobile != null) {
			if(employeeByMobile.getEmployeeId() != employee.getEmployeeId())
				throw new CustomUniqueKeyViolationException("This mobile number is already exists please provide new mobile number");
		}
		employeeDao.update(employee);
	}

}
