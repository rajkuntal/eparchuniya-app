package com.graminmart.app.domain.inventory;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.graminmart.app.domain.admin.Store;

@Entity
@Table(name = "inventory_stock")
public class Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7096483305688475352L;

	@Id
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_type_id")
	private ItemUnit itemUnitType;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@Column(name = "additional_params", length = 1000)
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

	public ItemUnit getItemUnitType() {
		return itemUnitType;
	}

	public void setItemUnitType(ItemUnit itemUnitType) {
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
