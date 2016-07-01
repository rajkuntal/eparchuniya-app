package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPackagingPricePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -619370949760683897L;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "packaging_id")
	private Packaging packaging;

	public ItemPackagingPricePK() {
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
