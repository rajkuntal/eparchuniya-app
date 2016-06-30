package com.eparchuniya.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="adm_employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3770760157350621228L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false)
	private int employeeId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = true)
	private String lastName;
	
	@Column(name = "father_name", nullable = true)
	private String fatherName;
	
	@Column(name = "email_id", nullable = true)
	private String emailId;
	
	@Column(name = "mobile_number", unique=true, nullable = false)
	private Long mobileNumber;
	
	@Column(name = "joining_date", nullable = false)
	private Timestamp joiningDate;

	@OneToOne
	@JoinColumn(name = "emp_address_id")
	private EmployeeAddress employeeAddress;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "designation_id")
	private Designation designation;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "created_ts", nullable = false)
	private Timestamp createdTs;
	
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	
	@Column(name = "modified_ts", nullable = false)
	private Timestamp modifiedTs;
	
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;
	

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


	public Timestamp getCreatedTs() {
		return createdTs;
	}


	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}


	public int getcreatedBy() {
		return createdBy;
	}


	public void setcreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getModifiedTs() {
		return modifiedTs;
	}


	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}


	public int getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
