package com.graminmart.app.dao.inventory;

import java.util.List;

import com.graminmart.app.domain.inventory.ItemPrice;

public interface ItemPriceDao {
	
	ItemPrice save(ItemPrice itemPrice);
	
	void remove(ItemPrice itemPrice);
	
	void removeNotInList(int itemId, List<Integer> packagingIds);
	
	void update(ItemPrice itemPrice);
	
	ItemPrice FindById(int itemId, int packagingId);

}
