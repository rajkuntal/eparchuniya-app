package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eparchuniya.app.domain.admin.User;

@Entity
@Table(name = "inventory_packaging")
public class Packaging implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2806743192066485218L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "packaging_id")
	private int packagingId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_type_id", updatable = false, nullable = false)
	private ItemType itemType;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_type_id", updatable = false, nullable = false)
	private UnitType unitType;
	
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name = "addition_params", length = 1000)
	private String additionParams;
	
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

	public Packaging() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPackagingId() {
		return packagingId;
	}

	public void setPackagingId(int packagingId) {
		this.packagingId = packagingId;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getAdditionParams() {
		return additionParams;
	}

	public void setAdditionParams(String additionParams) {
		this.additionParams = additionParams;
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
