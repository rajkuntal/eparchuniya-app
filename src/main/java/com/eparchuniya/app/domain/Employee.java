package com.eparchuniya.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="emp_employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3770760157350621228L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false)
	private int employeeId;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 50)
	private String lastName;
	
	@Column(name = "father_name", nullable = true, length = 100)
	private String fatherName;
	
	@Column(name = "email_id", nullable = true, length = 50)
	private String emailId;
	
	@Column(name = "mobile_number", unique=true, nullable = false)
	private Long mobileNumber;
	
	@Column(name = "joining_date", nullable = false)
	private Timestamp joiningDate;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_address_id")
	private EmployeeAddress employeeAddress;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_id")
	private Designation designation;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "last_day")
	private Timestamp lastDay;

	@Column(name = "created_at", nullable = false)
	private Timestamp createdTs;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Column(name = "modified_at")
	private Timestamp modifiedTs;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by")
	private User modifiedBy;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public Timestamp getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Timestamp joiningDate) {
		this.joiningDate = joiningDate;
	}


	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}


	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public Designation getDesignation() {
		return designation;
	}


	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Timestamp getLastDay() {
		return lastDay;
	}


	public void setLastDay(Timestamp lastDay) {
		this.lastDay = lastDay;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}


	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}


	public User getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getModifiedTs() {
		return modifiedTs;
	}


	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}


	public User getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
