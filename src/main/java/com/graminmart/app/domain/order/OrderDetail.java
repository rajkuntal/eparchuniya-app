package com.graminmart.app.domain.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_order_detail")
public class OrderDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4306762549972298060L;

	@EmbeddedId
	private OrderDetailPK orderDetailPK;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "cancled", nullable = false)
	private Boolean cancled;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailPK getOrderDetailPK() {
		return orderDetailPK;
	}

	public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
		this.orderDetailPK = orderDetailPK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getCancled() {
		return cancled;
	}

	public void setCancled(Boolean cancled) {
		this.cancled = cancled;
	}

}
