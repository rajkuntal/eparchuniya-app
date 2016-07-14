package com.eparchuniya.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.service.AdminService;

@RestController
@RequestMapping(value = "/adminmanagement")
public class AdminRestController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/store/add", method = RequestMethod.POST)
	public Store addStore(@RequestBody Store store) {
		return adminService.saveStore(store);
	}
	
	@RequestMapping(value = "/store/update", method = RequestMethod.POST)
	public void modifyStore(@RequestBody Store store) {
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
	public void addUser(@RequestBody User user){
		adminService.saveUser(user);
	}

}
