package com.eparchuniya.app.restcontroller;

import java.util.Date;

import javax.persistence.PersistenceException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.admin.LocationServed;
import com.eparchuniya.app.domain.admin.Store;
import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.exception.ApiError;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;
import com.eparchuniya.app.exception.ResponseCode;
import com.eparchuniya.app.exception.SuccessResponse;
import com.eparchuniya.app.security.service.LoggedInUserService;
import com.eparchuniya.app.service.AdminService;

@RestController
@RequestMapping(value = "/adminmanagement")
public class AdminRestController {

	private static final Logger logger = LoggerFactory.getLogger(AdminRestController.class);

	@Autowired
	private AdminService adminService;

	@Autowired
	private LoggedInUserService loggedInUserService;

	@RequestMapping(value = "/store/add", method = RequestMethod.POST)
	public ResponseEntity<?> addStore(@Valid @RequestBody Store store) {
		try{
			store.setIsActive(false);
			logger.info("saving new store " + store.getName());
			adminService.saveStore(store);
		} catch (CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getErrors());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(PersistenceException ex) {
			logger.error("error while saving new store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.ERROR, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("store : " + store.getName() + " created successfully");
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "store created successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/store/update", method = RequestMethod.POST)
	public ResponseEntity<?> modifyStore(@Valid @RequestBody Store store) {
		try{
			logger.info("updating new store " + store.getName());
			adminService.updateStore(store);
		} catch (NotExistException ex){
			logger.error("error while updating store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch (CustomUniqueKeyViolationException ex) {
			logger.error("error while updating store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getErrors());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(PersistenceException ex) {
			logger.error("error while updating store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("store : " + store.getName() + " updated successfully");
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "store updated successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/store/activate/{storeId}", method = RequestMethod.PUT)
	public ResponseEntity<?> activateStore(@PathVariable int storeId){
		try{
			logger.info("activating storeId : " + storeId);
			adminService.activateStore(storeId);
		} catch(NotExistException ex){
			logger.error("error while activating storeid :" + storeId + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("storeId : " + storeId + " activated successfully");
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "store activated successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/store/deactivate/{storeId}", method = RequestMethod.PUT)
	public ResponseEntity<?> deactivateStore(@PathVariable int storeId){
		try{
			logger.info("activating storeId : " + storeId);
			adminService.deactivateStore(storeId);
		} catch(NotExistException ex){
			logger.error("error while deactivating storeid :" + storeId + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("storeId : " + storeId + " deactivated successfully");
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "store deactivated successfully"), HttpStatus.OK);
	}

	
	@RequestMapping(value = "location/add", method = RequestMethod.POST)
	public ResponseEntity<?> addLocation(@Valid @RequestBody LocationServed locationServed) {
		try{
			locationServed.setIsActive(false);
			locationServed.setCreatedBy(loggedInUserService.getUser());
			locationServed.setCreatedTs(new Date());
			logger.info("saving location " + locationServed.getName());
			adminService.saveLocation(locationServed);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new location --> " + locationServed.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(PersistenceException ex) {
			logger.error("error while saving new location --> " + locationServed.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("location : " + locationServed.getName() + " created successfully");
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "location created successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "location/update", method = RequestMethod.PUT)
	public ResponseEntity<?> ModifyLocation(@Valid @RequestBody LocationServed locationServed) {
		try{
			locationServed.setModifiedBy(loggedInUserService.getUser());
			locationServed.setModifiedTs(new Date());
			logger.info("saving location " + locationServed.getName());
			adminService.updateLocation(locationServed);
		} catch(NotExistException ex) {
			logger.error("error while updating location --> " + locationServed.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("error while updating location --> " + locationServed.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(PersistenceException ex) {
			logger.error("error while updating location --> " + locationServed.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("location : " + locationServed.getName() + " updated successfully");
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "location updated successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value="location/activate/{locationId}", method = RequestMethod.PUT)
	public ResponseEntity<?> activateLocation(@PathVariable int locationId){
		try {
			logger.info("activating locationId : " + locationId);
			adminService.activateLocation(locationId, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("error while activating locationId: " + locationId +"-->"+ ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND,ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("locationId : " + locationId + " activated successfully");
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "Location is activated successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value="location/deactivate/{locationId}", method = RequestMethod.PUT)
	public ResponseEntity<?> deactivateLocation(@PathVariable int locationId){
		try {
			logger.info("activating locationId : " + locationId);
			adminService.deActivateLocation(locationId, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("error while deactivating locationId: " + locationId +" -->"+ ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND,ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("locationId : " + locationId + " deactivated successfully");
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "Location is deactivated successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {

		user.setCreatedBy(loggedInUserService.getUser());
		user.setCreatedTs(new Date());
		logger.info("saving new user " + user.getUserName());

		adminService.saveUser(user);
	}

	@RequestMapping(value = "/user/deactivate/{userId}", method = RequestMethod.POST)
	public void deactivateUser(@PathVariable int userId) {
		adminService.deactivateUser(userId, loggedInUserService.getUser().getUserId());
	}

	@RequestMapping(value = "/user/activate/{userId}", method = RequestMethod.POST)
	public void activateUser(@Valid @PathVariable int userId) {
		adminService.activateUser(userId, loggedInUserService.getUser().getUserId());
	}

}
