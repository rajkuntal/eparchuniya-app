package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_stock")
public class InventoryStock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7096483305688475352L;

	@Id
	@OneToOne
	@JoinColumn(name = "item_id")
	private InventoryItem item;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "unit_type_id")
	private InventoryUnitType itemUnitType;
	
	@Column(name = "quantity")
	private Double quantity;

	public InventoryStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryItem getItem() {
		return item;
	}

	public void setItem(InventoryItem item) {
		this.item = item;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public InventoryUnitType getItemUnitType() {
		return itemUnitType;
	}

	public void setItemUnitType(InventoryUnitType itemUnitType) {
		this.itemUnitType = itemUnitType;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	

}
