package com.eparchuniya.app.domain.customer;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "cust_mobile")
public class CustomerMobile extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263840806108576515L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "mobile number can not be empty")
	@Column(name = "mobile_number", nullable = false)
	private Long mobileNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "customer_id", nullable = false)
	private Customer customer;
	
	@NotNull(message = "CustomerMobile Verified can't be empty")
	@Column(name = "verified", nullable = false)
	private Boolean verified;
	
	@Column(name = "blocked", nullable = false)
	private Boolean blocked;
	
	@Column(name = "block_comments")
	private String comments;
	
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

	public CustomerMobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
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
	

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
