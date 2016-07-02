package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "stock_credit_detail")
public class StockCreditDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3176522010999853889L;

	@EmbeddedId
	private StockCreditDetailPK stockCreditDetailPK;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "comments", length = 255)
	private String comments;

	public StockCreditDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockCreditDetailPK getStockCreditDetailPK() {
		return stockCreditDetailPK;
	}

	public void setStockCreditDetailPK(StockCreditDetailPK stockCreditDetailPK) {
		this.stockCreditDetailPK = stockCreditDetailPK;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
		
}
