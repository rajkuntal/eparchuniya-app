package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "display_name", nullable = false)
	private String displayName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "brand_name", nullable = false)
	private String brandName;
	
	@Column(name = "additional_params")
	private String additionalParams;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "item_type_id")
	private ItemType itemType;
	
	@ManyToOne
	@JoinColumn(name = "item_unit_id")
	private UnitType unit;
	
	@ManyToMany
	@JoinTable(name = "inventory_item_stock_unit"
				, joinColumns = @JoinColumn(name = "item_id")
				, inverseJoinColumns = @JoinColumn(name = "stock_unit_type_id"))
	private Set<StockUnitType> inventoryStockUnitTypes;
	
	@ManyToMany
	@JoinTable(name = "inventory_item_packaging"
				, joinColumns = @JoinColumn(name = "item_id")
				, inverseJoinColumns = @JoinColumn(name = "packaging_id"))
	private Set<Packaging> inventoryPackagingTypes;
	
	@Column(name = "created_at", nullable = false)
	private Timestamp createdTs;
	
	@ManyToOne
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Column(name = "modified_at")
	private Timestamp modifiedTs;
	
	@ManyToOne
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

	public Set<Packaging> getInventoryPackagingTypes() {
		return inventoryPackagingTypes;
	}

	public void setInventoryPackagingTypes(Set<Packaging> inventoryPackagingTypes) {
		this.inventoryPackagingTypes = inventoryPackagingTypes;
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
