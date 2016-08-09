package com.eparchuniya.app.restcontroller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.employee.Designation;
import com.eparchuniya.app.domain.employee.Employee;
import com.eparchuniya.app.exception.ApiError;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;
import com.eparchuniya.app.exception.ResponseCode;
import com.eparchuniya.app.exception.SuccessResponse;
import com.eparchuniya.app.security.service.LoggedInUserService;
import com.eparchuniya.app.service.EmployeeService;

@RestController
@RequestMapping(value = "/employeemanagement")
public class EmployeeRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LoggedInUserService loggedInUserService;
	
	@RequestMapping(value = "/designation/add", method = RequestMethod.POST)
	public ResponseEntity<?> addDesignation(@Valid @RequestBody Designation designation) {
		try{
			logger.info("saving new designation : " + designation.getName());
			employeeService.saveDesignation(designation);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while saving designation " + designation.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("new designation saved successfully " + designation.getName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Designation saved successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/designation/update", method = RequestMethod.PUT)
	public ResponseEntity<?> modifyDesignation(@Valid @RequestBody Designation designation) {
		try{
			logger.info("saving new designation : " + designation.getName());
			employeeService.updateDesignation(designation);
		} catch(NotExistException ex) {
			logger.error("error while saving designation " + designation.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while saving designation " + designation.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("designation updated successfully " + designation.getName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Designation updated successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
		try{
			employee.setIsActive(false);
			employee.setCreatedBy(loggedInUserService.getUser());
			employee.setCreatedTs(new Date());
			logger.info("saving new employee + " + employee.getFirstName());
			employeeService.saveEmployee(employee);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new employee " + employee.getFirstName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("Employee added successfully " + employee.getFirstName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Employee added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try{
			employee.setIsActive(false);
			employee.setCreatedBy(loggedInUserService.getUser());
			employee.setCreatedTs(new Date());
			logger.info("saving new employee + " + employee.getFirstName());
			employeeService.updateEmployee(employee);
		} catch(NotExistException ex) {
			logger.error("error while updating employee " + employee.getFirstName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while updating employee " + employee.getFirstName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("Employee updated successfully " + employee.getFirstName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Employee updated successfully"), HttpStatus.OK);
	}

}
