package com.eparchuniya.app.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.eparchuniya.app.domain.basedomain.BaseDomain;


@Entity
@Table(name="emp_employee")
public class Employee extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3770760157350621228L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false)
	private int employeeId;
	
	@NotNull(message = "{Employee.firstName can't be null}")
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 50)
	private String lastName;
	
	@Column(name = "father_name", nullable = true, length = 100)
	private String fatherName;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="{invalid.email}")
	@Column(name = "email_id", nullable = true, length = 50)
	private String emailId;
	
	@NotNull(message = "{Employee.mobileNumber can't be null}")
//	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
//            message="{Employee.invalid.mobileNumber}")
	@Column(name = "mobile_number", unique=true, nullable = false)
	private Long mobileNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "{Employee.joiningDate can't be null}")
	@Column(name = "joining_date", nullable = false)
	private Date joiningDate;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_address_id")
	private EmployeeAddress employeeAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "designation_id")
	private Designation designation;
	
	@NotNull(message = "{Employee.isActive can't be null}")
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_day")
	private Date lastDay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modifiedTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
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


	public Date getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Date joiningDate) {
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

	public Date getLastDay() {
		return lastDay;
	}


	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	public Date getCreatedTs() {
		return createdTs;
	}


	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}


	public User getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public Date getModifiedTs() {
		return modifiedTs;
	}


	public void setModifiedTs(Date modifiedTs) {
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
