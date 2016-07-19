package com.eparchuniya.app.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eparchuniya.app.domain.basedomain.BaseDomain;

@Entity
@Table(name = "cust_mobile")
public class CustomerMobile extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263840806108576515L;

	@Id
	@Column(name = "mobile_number")
	private Long mobileNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "customer_id", nullable = false)
	private Customer customer;
	
	@NotNull(message = "{CustomerMobile.isVerified can't be null}")
	@Column(name = "verified", nullable = false)
	private Boolean verified;
	
	@NotNull(message = "{CustomerMobile.blocked can't be null}")
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
		return verified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.verified = isVerified;
	}
}
