package com.eparchuniya.app.domain;

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
@Table(name = "inventory_item_packaging_type")
public class InventoryItemPackagingType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "packaging_type_id")
	private int packagingTypeId;
	
	@ManyToOne
	@JoinColumn(name = "item_type")
	private InventoryItemType itemType;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "comments", nullable = false)
	private String comments;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "created_ts", nullable = false)
	private Timestamp createdTs;
	
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	
	@Column(name = "modified_ts", nullable = false)
	private Timestamp modifiedTs;
	
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;

	public InventoryItemPackagingType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPackagingTypeId() {
		return packagingTypeId;
	}

	public void setPackagingTypeId(int packagingTypeId) {
		this.packagingTypeId = packagingTypeId;
	}

	public InventoryItemType getItemType() {
		return itemType;
	}

	public void setItemType(InventoryItemType itemType) {
		this.itemType = itemType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
