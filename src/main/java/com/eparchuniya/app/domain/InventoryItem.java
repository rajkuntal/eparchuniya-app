package com.eparchuniya.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "brand_name", nullable = false)
	private String brandName;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private InventoryItemCategory itemCategory;
	
	@ManyToOne
	@JoinColumn(name = "item_type_id")
	private InventoryItemType itemType;
	
	@ManyToOne
	@JoinColumn(name = "item_unit_type_id")
	private IinventoryItemUnitType itemUnitType;
	
	@Column(name = "created_ts", nullable = false)
	private Timestamp createdTs;
	
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	
	@Column(name = "modified_ts", nullable = false)
	private Timestamp modifiedTs;
	
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;
	

}
