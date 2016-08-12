package com.eparchuniya.app.domain.inventory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "inventory_item")
public class Item extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2930608929483272819L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "code", nullable = false, length = 20, unique = true)
	private String code;
	
	@Size(max = 255, message = "Item display Name cann't be greater than 255 characters")
	@NotEmpty(message = "Item display Name cann't be empty")
	@NotNull(message = "Item display Name cann't be null")
	@Column(name = "display_name", nullable = false, length = 255)
	private String displayName;
	
	@Size(max = 255, message = "Item Name cann't be greater than 255 characters")
	@NotEmpty(message = "Item Name cann't be empty")
	@NotNull(message = "Item Name cann't be null")
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Size(max = 255, message = "Item brand Name cann't be greater than 255 characters")
	@NotEmpty(message = "Item brand Name cann't be empty")
	@NotNull(message = "Item brand Name cann't be null")
	@Column(name = "brand_name", nullable = false, length = 100)
	private String brandName;
	
	@Column(name = "additional_params", length = 1000)
	private String additionalParams;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_type_id")
	private ItemType itemType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_unit_id")
	private ItemUnit unit;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "inventory_item_stock_unit"
				, joinColumns = @JoinColumn(name = "item_id")
				, inverseJoinColumns = @JoinColumn(name = "stock_unit_type_id"))
	private Set<StockUnitType> inventoryStockUnitTypes;
	
	@Transient
	private List<Packaging> packagings;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_ts", nullable = false)
	private Date createdTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_ts")
	private Date modifiedTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
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

	public ItemUnit getUnit() {
		return unit;
	}

	public void setUnit(ItemUnit unit) {
		this.unit = unit;
	}

	public Set<StockUnitType> getInventoryStockUnitTypes() {
		return inventoryStockUnitTypes;
	}

	public void setInventoryStockUnitTypes(Set<StockUnitType> inventoryStockUnitTypes) {
		this.inventoryStockUnitTypes = inventoryStockUnitTypes;
	}
	
	public List<Packaging> getPackagings() {
		return packagings;
	}

	public void setPackagings(List<Packaging> packagings) {
		this.packagings = packagings;
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

	public String getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String additionalParams) {
		this.additionalParams = additionalParams;
	}
	

}
