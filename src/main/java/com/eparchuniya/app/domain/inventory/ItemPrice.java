package com.eparchuniya.app.domain.inventory;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "inventory_item_price")
public class ItemPrice extends BaseDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2720263731427968887L;

	@EmbeddedId
	private ItemPricePK itemPricePK;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "packaging_price")
	private Double packagingPrice;
	
	@Column(name = "delivery_price")
	private Double deliveryPrice;
	
	@Column(name = "additional_params", length = 1000)
	private String additionalParams;
	
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

	public ItemPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemPricePK getItemPricePK() {
		return itemPricePK;
	}

	public void setItemPricePK(ItemPricePK itemPricePK) {
		this.itemPricePK = itemPricePK;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPackagingPrice() {
		return packagingPrice;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public void setPackagingPrice(Double packagingPrice) {
		this.packagingPrice = packagingPrice;
	}

	public String getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String additionalParams) {
		this.additionalParams = additionalParams;
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


}
