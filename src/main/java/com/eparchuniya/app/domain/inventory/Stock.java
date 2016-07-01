package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eparchuniya.app.domain.Store;

@Entity
@Table(name = "inventory_stock")
public class Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7096483305688475352L;

	@Id
	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "unit_type_id")
	private UnitType itemUnitType;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@Column(name = "additional_params")
	private String additionalParams;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public UnitType getItemUnitType() {
		return itemUnitType;
	}

	public void setItemUnitType(UnitType itemUnitType) {
		this.itemUnitType = itemUnitType;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String additionalParams) {
		this.additionalParams = additionalParams;
	}
	

}
