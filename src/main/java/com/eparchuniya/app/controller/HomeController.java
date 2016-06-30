package com.eparchuniya.app.controller;


import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.dao.DesignationDao;
import com.eparchuniya.app.dao.EmployeeAddressDao;
import com.eparchuniya.app.dao.EmployeeDao;
import com.eparchuniya.app.dao.OrderSummaryDao;
import com.eparchuniya.app.dao.StoreDao;
import com.eparchuniya.app.domain.Designation;
import com.eparchuniya.app.domain.Employee;
import com.eparchuniya.app.domain.EmployeeAddress;
import com.eparchuniya.app.domain.OrderSummary;
import com.eparchuniya.app.domain.Store;
import com.eparchuniya.app.domain.UserGroup;
import com.eparchuniya.app.service.EmployeeService;

@RestController
public class HomeController {

	
//	@Autowired
//	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private DesignationDao designationDao;
	
	@Autowired
	private EmployeeAddressDao employeeAddressDao;
	
	@Autowired
	private OrderSummaryDao orderSummaryDao;
//	
//	@Autowired
//	private DesignationDao designationDao;
	
	@RequestMapping(value = "/eadmin", method = RequestMethod.GET)
	public String GetHomePage() {
		
		return "myapp/navigationbar";
	}
	
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String Getdemopage() {
		
		return "demopage";
	}
	
	@RequestMapping(value = "/ambertableexample", method = RequestMethod.GET)
	public String GetAmberTableExamplePage() {
		
		return "embertableexample";
	}
	
	@RequestMapping(value = "/emberchartexample", method = RequestMethod.GET)
	public String GetAmberChartExamplePage() {
		
		return "aberchartexample";
	}
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "sessionexample/welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "sessionexample/admin";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "sessionexample/dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "sessionexample/accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "sessionexample/login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/checksecurity", method = RequestMethod.POST)
	@ResponseBody
	public UserGroup checkSecurity() {
		return new UserGroup("1", "hello", "yes");
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	//@ResponseBody
	@RequestMapping(value="/addemployee", method = RequestMethod.POST)
	public void addEmployee(@RequestBody Employee emp){
		employeeDao.saveEmployee(emp);
	}
	
	//@ResponseBody
	@RequestMapping(value="/addstore", method = RequestMethod.POST)
	public void addStore(@RequestBody Store store) {
		storeDao.addStore(store);
	}
	
	@RequestMapping(value="/adddesignation", method = RequestMethod.POST)
	public void addDesignation(@RequestBody Designation designation) {
		designationDao.addDesignation(designation);
	}
	
	@RequestMapping(value = "/addemployeeadress", method = RequestMethod.POST)
	public void addEmployeeAddress(@RequestBody EmployeeAddress employeeAddress) {
		employeeAddressDao.addEmployeeAddress(employeeAddress);
	}
	
	@RequestMapping(value = "/checkobject", method = RequestMethod.POST, consumes="application/json")
	public void addEmp(@RequestBody String employeeRequest) {
		//
	}
	
	
	@RequestMapping(value = "/addordersummary", method = RequestMethod.POST)
	public void addEmp(@RequestBody OrderSummary orderSummary) {
		orderSummaryDao.addOrderSummary(orderSummary);
	}
//	
//	@RequestMapping(value="/adddesignation", method = RequestMethod.POST)
//	public void addDesignation(Designation designation) {
//		designationDao.addDesignation(designation);
//	}

}