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
@Table(name = "inventory_stock_unit_type")
public class StockUnitType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3342786963144389790L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_unit_type_id")
	private int stockUnitTypeId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private ItemType typeId;
	
	@Column(name = "code", nullable = false, length = 50)
	private String code;
	
	@Column(name = "display_name", nullable = false, length = 100)
	private String displayName;
	
	@Column(name = "quantity", nullable = false)
	private Double quantity;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_type_id")
	private ItemUnit unitType;
	
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

	public StockUnitType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStockUnitTypeId() {
		return stockUnitTypeId;
	}

	public void setStockUnitTypeId(int stockUnitTypeId) {
		this.stockUnitTypeId = stockUnitTypeId;
	}

	public ItemType getTypeId() {
		return typeId;
	}

	public void setTypeId(ItemType typeId) {
		this.typeId = typeId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public ItemUnit getUnitType() {
		return unitType;
	}

	public void setUnitType(ItemUnit unitType) {
		this.unitType = unitType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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