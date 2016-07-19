package com.eparchuniya.app.restcontroller;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

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

import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.domain.exception.CustomPersistenceException;
import com.eparchuniya.app.domain.exception.UniqueKeyViolationException;
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
	public ResponseEntity<Store> addStore(@RequestBody Store store) {
		Store store1 = null;
		try {
			logger.info("saving new store " + store.getName());
			store1 = adminService.saveStore(store);
		} catch (UniqueKeyViolationException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Store>(HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (CustomPersistenceException e) {
			logger.error(e.getMessage() + store.getName());
			return new ResponseEntity<Store>(HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info(store.getName() +" entity saved successfully");
		return new ResponseEntity<Store>(store ,HttpStatus.OK);

	}

	@RequestMapping(value = "/store/update", method = RequestMethod.POST)
	public void modifyStore(@RequestBody Store store) {

		logger.info("updating store info " + store.getName());
		adminService.updateStore(store);
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
	public void activateUser(@PathVariable int userId) {
		adminService.activateUser(userId, loggedInUserService.getUser().getUserId());
	}

}
