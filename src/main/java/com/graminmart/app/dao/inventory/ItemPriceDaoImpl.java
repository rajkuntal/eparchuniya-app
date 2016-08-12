package com.graminmart.app.dao.inventory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.graminmart.app.domain.inventory.ItemPrice;

@Repository("itemPriceDao")
public class ItemPriceDaoImpl implements ItemPriceDao{
	
	@PersistenceContext
	private EntityManager em;

	public ItemPrice save(ItemPrice itemPrice) {
		em.persist(itemPrice);
		return itemPrice;
	}

	public void remove(ItemPrice itemPrice) {
		em.remove(itemPrice);
	}

	public void update(ItemPrice itemPrice) {
		em.merge(itemPrice);
	}

	public void removeNotInList(int itemId, List<Integer> packagingIds) {
		em.createNativeQuery("DELETE FROM inventory_item_price WHERE item_id = ?1 AND packaging_id NOT IN ?2")
		.setParameter(1, itemId)
		.setParameter(2, packagingIds)
		.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ItemPrice FindById(int itemId, int packagingId) {
		List<ItemPrice> itemPrices = em.createNativeQuery("SELECT * FROM inventory_item_price WHERE item_id = ?1 AND packaging_id = ?2", ItemPrice.class)
				.setParameter(1, itemId)
				.setParameter(2, packagingId)
				.getResultList();
		if(!itemPrices.isEmpty())
			return itemPrices.get(0);
		else
			return null;
	}
	
}
	