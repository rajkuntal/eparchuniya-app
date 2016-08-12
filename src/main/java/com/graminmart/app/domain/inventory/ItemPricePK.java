package com.graminmart.app.domain.inventory;


import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.graminmart.app.domain.base.BaseDomain;

@Embeddable
public class ItemPricePK extends BaseDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -619370949760683897L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packaging_id")
	private Packaging packaging;

	public ItemPricePK() {
		super();
		// TODO Auto-generated constructor stub
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
