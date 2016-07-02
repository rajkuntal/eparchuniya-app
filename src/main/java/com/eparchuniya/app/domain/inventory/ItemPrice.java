package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_item_packaging_price")
public class ItemPrice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2720263731427968887L;

	@EmbeddedId
	private ItemPricePK itemPackagingPricePK;
	
	@Column(name = "packaging_price")
	private Double packagingPrice;
	
	@Column(name = "item_price")
	private Double itemPrice;
	
	@Column(name = "additional_params", length = 1000)
	private String additionalParams;

	public ItemPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemPricePK getItemPackagingPricePK() {
		return itemPackagingPricePK;
	}

	public void setItemPackagingPricePK(ItemPricePK itemPackagingPricePK) {
		this.itemPackagingPricePK = itemPackagingPricePK;
	}

	public Double getPackagingPrice() {
		return packagingPrice;
	}

	public void setPackagingPrice(Double packagingPrice) {
		this.packagingPrice = packagingPrice;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String additionalParams) {
		this.additionalParams = additionalParams;
	}

}
