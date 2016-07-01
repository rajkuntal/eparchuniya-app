package com.eparchuniya.app.domain.order;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eparchuniya.app.domain.inventory.Item;
import com.eparchuniya.app.domain.inventory.Packaging;

@Embeddable
public class OrderDetailPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8163367718968236332L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderSummary orderSummary;
	
	@ManyToOne
	@JoinColumn(name = "itme_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "packaging_id")
	private Packaging packaging;

	public OrderDetailPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderSummary getOrderSummary() {
		return orderSummary;
	}

	public void setOrderSummary(OrderSummary orderSummary) {
		this.orderSummary = orderSummary;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Packaging getPackaging() {
		return packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}
	

}
