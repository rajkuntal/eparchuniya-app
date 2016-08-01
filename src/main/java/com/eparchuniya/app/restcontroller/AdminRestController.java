package com.eparchuniya.app.restcontroller;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.ViewportLayout;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
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
			logger.info("saving new store " + store.getName());
			adminService.saveStore(store);
		} catch (CustomUniqueKeyViolationException ex) {
			logger.error("error while saving new store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUEKEYVIOLATION, ex.getErrors());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(PersistenceException ex) {
			logger.error("error while saving new store --> " + store.getName() + " " + ex.getMessage());
			return new ResponseEntity<Store>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
			ApiError apiError = new ApiError(ResponseCode.NOTFOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch (CustomUniqueKeyViolationException ex) {
			logger.error("error while updating store --> " + store.getName() + " " + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUEKEYVIOLATION, ex.getErrors());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		} catch(PersistenceException ex) {
			logger.error("error while updating store --> " + store.getName() + " " + ex.getMessage());
			return new ResponseEntity<Store>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		SuccessResponse successResponse = new SuccessResponse(ResponseCode.OK, "store updated successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public List<Store> retriveAllStore() {
		return adminService.getAllStores();
	}

	@RequestMapping(value = "/store/{name}", method = RequestMethod.GET)
	public Store retriveStoreByName(@PathVariable String name) {
		return adminService.findStoreByName(name);
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
