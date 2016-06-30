package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adm_customer_mobile_mapping")
public class CustomerMobileMapping implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7171022759799538027L;
	
	@Id
	@Column(name = "mobile_number")
	private Long mobileNumber;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "is_active")
	private Boolean isActive;

	public CustomerMobileMapping() {
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
