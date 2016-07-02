package com.eparchuniya.app.domain.inventory;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eparchuniya.app.domain.User;

@Entity
@Table(name = "inventory_item")
public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2930608929483272819L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "code", nullable = false, length = 20)
	private String code;
	
	@Column(name = "display_name", nullable = false, length = 255)
	private String displayName;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "brand_name", nullable = false, length = 100)
	private String brandName;
	
	@Column(name = "additional_params", length = 1000)
	private String additionalParams;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_type_id")
	private ItemType itemType;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_unit_id")
	private UnitType unit;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "inventory_item_stock_unit"
				, joinColumns = @JoinColumn(name = "item_id")
				, inverseJoinColumns = @JoinColumn(name = "stock_unit_type_id"))
	private Set<StockUnitType> inventoryStockUnitTypes;
	
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

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public UnitType getUnit() {
		return unit;
	}

	public void setUnit(UnitType unit) {
		this.unit = unit;
	}

	public Set<StockUnitType> getInventoryStockUnitTypes() {
		return inventoryStockUnitTypes;
	}

	public void setInventoryStockUnitTypes(Set<StockUnitType> inventoryStockUnitTypes) {
		this.inventoryStockUnitTypes = inventoryStockUnitTypes;
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

	public String getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String additionalParams) {
		this.additionalParams = additionalParams;
	}
	

}
