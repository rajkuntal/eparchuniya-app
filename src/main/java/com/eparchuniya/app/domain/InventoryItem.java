package com.eparchuniya.app.domain;

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

@Entity
@Table(name = "inventory_item")
public class InventoryItem implements Serializable {
	
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
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private InventoryCategory category;
	
	@ManyToOne
	@JoinColumn(name = "item_type_id")
	private InventoryItemType itemType;
	
	@ManyToOne
	@JoinColumn(name = "item_unit_id")
	private InventoryUnitType unit;
	
	@ManyToMany
	@JoinTable(name = "inventory_item_stock_unit"
				, joinColumns = @JoinColumn(name = "item_id")
				, inverseJoinColumns = @JoinColumn(name = "stock_unit_type_id"))
	private Set<InventoryStockUnitType> inventoryStockUnitTypes;
	
	@ManyToMany
	@JoinTable(name = "inventory_item_packaging"
				, joinColumns = @JoinColumn(name = "item_id")
				, inverseJoinColumns = @JoinColumn(name = "packaging_id"))
	private Set<InventoryPackaging> inventoryPackagingTypes;
	
	@Column(name = "created_ts", nullable = false)
	private Timestamp createdTs;
	
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	
	@Column(name = "modified_ts", nullable = false)
	private Timestamp modifiedTs;
	
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;
	

}
