package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StockCreditDetailPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 511358566463309741L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_id", nullable = false)
	private StockCreditSummary stockCreditSummary;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_unit_type_id", nullable = false)
	private StockUnitType stockUnitType;

	public StockCreditDetailPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockCreditSummary getStockCreditSummary() {
		return stockCreditSummary;
	}

	public void setStockCreditSummary(StockCreditSummary stockCreditSummary) {
		this.stockCreditSummary = stockCreditSummary;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public StockUnitType getStockUnitType() {
		return stockUnitType;
	}

	public void setStockUnitType(StockUnitType stockUnitType) {
		this.stockUnitType = stockUnitType;
	}

}
