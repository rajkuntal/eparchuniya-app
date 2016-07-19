package com.eparchuniya.app.restcontroller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.Designation;
import com.eparchuniya.app.domain.Employee;
import com.eparchuniya.app.service.EmployeeService;

@RestController
@RequestMapping(value = "/employeemanagement")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/designation/add", method = RequestMethod.POST)
	public Designation addDesignation(@RequestBody Designation designation) {
		return employeeService.saveDesignation(designation);
	}
	
	@RequestMapping(value = "/designation/update", method = RequestMethod.POST)
	public Designation updateDesignation(@RequestBody Designation designation) {
		return employeeService.saveDesignation(designation);
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setCreatedTs(new Date());
		employee.setJoiningDate(new Date());
		employee.setIsActive(true);
		return employeeService.saveEmployee(employee);
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}

}
