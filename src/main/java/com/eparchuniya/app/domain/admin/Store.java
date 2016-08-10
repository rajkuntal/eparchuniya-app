package com.eparchuniya.app.domain.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "admin_store")
public class Store extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6378454662250408617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int storeId;
	
	@NotNull(message = "Store code can't be empty")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Invalid store code - special characters are not allowed")
	@Size(max=20, message = "store code max size 20")
	@Column(name = "code", nullable = false, length = 20, unique = true)
	private String code;

	@NotNull(message = "Store code can't be empty")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Invalid store name - special characters are not allowed")
	@Size(max=50, message = "store name max size 50")
	@Column(name = "name", nullable = false, length = 50, unique = true)
	private String name;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
