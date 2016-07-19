package com.eparchuniya.app.domain;

import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eparchuniya.app.common.util.Gender;
import com.eparchuniya.app.common.util.Relation;
import com.eparchuniya.app.domain.basedomain.BaseDomain;

@Entity
@Table(name = "cust_customer")
public class Customer extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6694531446320849204L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", nullable = false)
	private Long customerId;
	
	@NotNull(message = "{Customer.firstName can't be null}")
	@Size(max = 100, message = "{Customer.firstName max size 100}")
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 100)
	private String lastName;
	
	@Column(name = "relation", nullable = true, length = 20)
	private Relation relation;
	
	@Column(name = "faimly_person_name", nullable = true, length = 100)
	private String faimlyPersonName;
	
	private Gender gender;
	
	@Column(name = "email_id", nullable = true, length = 50)
	private String emailId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<CustomerMobile> mobileNumbers;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cust_customer_address"
				, joinColumns = @JoinColumn(name = "customer_id")
				, inverseJoinColumns = @JoinColumn(name = "cust_address_id"))
	private Set<CustomerAddress> customerAddresses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@NotNull(message = "{Customer.isVerified can't be null}")
	@Column(name = "verified", nullable = false)
	private Boolean verified;
	
	@NotNull(message = "{Customer.blocked can't be null}")
	@Column(name = "blocked")
	private Boolean blocked;
	
	@Column(name = "created_at", nullable = false)
	private Date createdTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Column(name = "modified_at")
	private Date modifiedTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
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

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public String getFaimlyPersonName() {
		return faimlyPersonName;
	}

	public void setFaimlyPersonName(String faimlyPersonName) {
		this.faimlyPersonName = faimlyPersonName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
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
		return verified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.verified = isVerified;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
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

}
