package com.eparchuniya.app.domain.example;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exml_employee")
public class EmployeeRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490236087642974668L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "exml_emp_add_mapping"
				, joinColumns = @JoinColumn(name = "empid")
				, inverseJoinColumns = @JoinColumn(name = "addId"))
	private Set<EmpAddress> empAddresses;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "deptId")
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<EmpAddress> getEmpAddresses() {
		return empAddresses;
	}

	public void setEmpAddresses(Set<EmpAddress> empAddresses) {
		this.empAddresses = empAddresses;
	}	

}
