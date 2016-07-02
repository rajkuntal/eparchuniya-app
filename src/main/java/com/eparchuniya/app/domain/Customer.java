package com.eparchuniya.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eparchuniya.app.common.util.Relation;

@Entity
@Table(name = "cust_customer")
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6694531446320849204L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", nullable = false)
	private Long customerId;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 50)
	private String lastName;
	
	@Column(name = "relation", nullable = true)
	private String relation;
	
	@Column(name = "faimly_person_name", nullable = false, length = 20)
	private Relation faimlyPersonName;
	
	private String gender;
	
	@Column(name = "email_id", nullable = true, length = 20)
	private String emailId;
	
//	@Column(name = "mobile_number", nullable = false, unique = true)
//	@JoinTable(name = "cust_customer_mobile")
//	@ElementCollection(targetClass = Long.class)
//	private Set<Long> mobileNumbers;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<CustomerMobile> mobileNumbers;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "cust_customer_address"
				, joinColumns = @JoinColumn(name = "customer_id")
				, inverseJoinColumns = @JoinColumn(name = "cust_address_id"))
	private Set<CustomerAddress> customerAddresses;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@Column(name = "is_verified", nullable = false)
	private Boolean isVerified;
	
	@Column(name = "blocked")
	private Boolean blocked;
	
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

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Relation getFaimlyPersonName() {
		return faimlyPersonName;
	}

	public void setFaimlyPersonName(Relation faimlyPersonName) {
		this.faimlyPersonName = faimlyPersonName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}


	public Set<CustomerMobile> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<CustomerMobile> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public Set<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}


	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
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

}
