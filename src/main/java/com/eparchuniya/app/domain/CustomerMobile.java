package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_customer_mobile")
public class CustomerMobile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263840806108576515L;

	@Id
	@Column(name = "mobile_number")
	private Long mobileNumber;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name  = "customer_id", nullable = false)
	private Customer customer;
	
	@Column(name = "is_verified", nullable = false)
	private Boolean isVerified;
	
	@Column(name = "blocked", nullable = false)
	private Boolean blocked;

	public CustomerMobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
}
