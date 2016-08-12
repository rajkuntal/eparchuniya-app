package com.eparchuniya.app.dao.inventory;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.inventory.Item;
import com.eparchuniya.app.domain.inventory.ItemType;

@Repository("itemDao")
public class ItemDaoImpl extends GenericDaoImpl<Item, Integer> implements ItemDao {

	@SuppressWarnings("unchecked")
	public Item findByCode(String code) {
		List<Item> items = em.createQuery("SELECT i FROM Item i WHERE i.code = ?1")
							.setParameter(1, code)
							.getResultList();
		if(!items.isEmpty())
			return items.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public int countByTypeId(ItemType itemType) {
		List<Item> items = em.createQuery("SELECT i FROM Item i WHERE i.itemType = ?1")
							.setParameter(1, itemType)
							.getResultList();
		if(!items.isEmpty())
			return items.size();
		else
			return 0;
	}

}
