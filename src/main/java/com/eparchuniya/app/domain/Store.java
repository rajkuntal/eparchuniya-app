package com.eparchuniya.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_store")
public class Store implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6378454662250408617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int storeId;
	
	@Column(name = "code", nullable = false, length = 20)
	private String code;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name = "start_date")
	private Timestamp startDate;

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

}
