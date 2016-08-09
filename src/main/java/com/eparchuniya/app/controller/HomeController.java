package com.eparchuniya.app.controller;


import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.domain.example.Department;
import com.eparchuniya.app.domain.example.EmpAddress;
import com.eparchuniya.app.domain.example.EmployeeRequest;
import com.eparchuniya.app.domain.example.UserGroup;


@RestController
public class HomeController {
	
	
	@PersistenceContext
	private EntityManager em;
	
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
	
	@RequestMapping(value="/checksecurity", method = RequestMethod.POST)
	@ResponseBody
	public UserGroup checkSecurity() {
		
		String str = getPrincipal();
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
	
	@Transactional
	@RequestMapping(value = "/addexampleemployee", method = RequestMethod.POST)
	public void addexample(@RequestBody ExampleRequest example) {
		
		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setFirstName(example.getFirstName());
		employeeRequest.setLastName(example.getLastName());
		
		HashSet<EmpAddress> empAddresses = new HashSet<EmpAddress>();
		EmpAddress empAddress1 = new EmpAddress();
		empAddress1.setColony(example.getColony1());
		
		EmpAddress empAddress2 = new EmpAddress();
		empAddress2.setColony(example.getColony2());
		
		EmpAddress empAddress3 = new EmpAddress();
		empAddress3.setColony(example.getColony3());
		
		empAddresses.add(empAddress1);
		empAddresses.add(empAddress2);
		empAddresses.add(empAddress3);
		
		//Department department =  (Department) sessionFactory.getCurrentSession().get(Department.class, example.getDeptId());
		
		Department department = em.find(Department.class, example.getDeptId());
		
		employeeRequest.setEmpAddresses(empAddresses);
		employeeRequest.setDepartment(department);
		
		em.merge(employeeRequest);
	}
	
	@Transactional
	@RequestMapping(value = "/addexampleaddress/{id}", method = RequestMethod.POST)
	public void addexampleaddress(@RequestBody ExampleRequest example, @PathVariable("id") int empId) {
		
		//EmployeeRequest employeeRequest = (EmployeeRequest) sessionFactory.getCurrentSession().get(EmployeeRequest.class, empId);
		
		EmployeeRequest employeeRequest = em.find(EmployeeRequest.class, empId);
		
		EmpAddress empAddress1 = new EmpAddress();
		empAddress1.setColony(example.getColony1());
		
		Hibernate.initialize(employeeRequest.getEmpAddresses());
		
		employeeRequest.getEmpAddresses().add(empAddress1);
		
		//sessionFactory.getCurrentSession().saveOrUpdate(employeeRequest);
		
		em.merge(employeeRequest);
	}
	
	@Transactional
	@RequestMapping(value = "/deleteexampleemployee/{id}", method = RequestMethod.POST)
	public void deleteexample(@PathVariable("id") int empId) {
		
//		EmployeeRequest employeeRequest = (EmployeeRequest) sessionFactory.getCurrentSession().get(EmployeeRequest.class, empId);
//		
//		sessionFactory.getCurrentSession().delete(employeeRequest);
		
		EmployeeRequest employeeRequest = em.find(EmployeeRequest.class, empId);
		
		em.merge(employeeRequest);
	}
	
	@Transactional
	@RequestMapping(value = "/deleteexampleaddress/{id}", method = RequestMethod.POST)
	public void deleteexampleaddress(@PathVariable("id") int addId) {
		
//		EmpAddress empAddress = (EmpAddress) sessionFactory.getCurrentSession().get(EmpAddress.class, addId);
//		
//		sessionFactory.getCurrentSession().delete(empAddress);
		
		EmpAddress empAddress = em.find(EmpAddress.class, addId);
		
		em.remove(empAddress);
	}
	
	@Transactional
	@RequestMapping(value = "/addexampledepartment", method = RequestMethod.POST)
	public void addexampldepartment(@RequestBody ExampleRequest example) {
		
		Department department = new Department();
		department.setName(example.getDptName());
		
		em.merge(department);
	}


}
