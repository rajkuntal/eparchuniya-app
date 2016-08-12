package com.graminmart.app.dao.inventory;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.graminmart.app.dao.generic.GenericDaoImpl;
import com.graminmart.app.domain.inventory.ItemType;

@Repository("itemTypeDao")
public class ItemTypeDaoImpl extends GenericDaoImpl<ItemType, Integer>implements ItemTypeDao {

	@SuppressWarnings("unchecked")
	public ItemType findByCode(String code) {
		List<ItemType> itemTypes = em.createQuery("SELECT i FROM ItemType i WHERE i.code = ?1")
				.setParameter(1, code)
				.getResultList();
		if (!itemTypes.isEmpty())
			return itemTypes.get(0);
		else
			return null;
	}

}
