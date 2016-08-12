package com.graminmart.app.dao.inventory;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.graminmart.app.dao.generic.GenericDaoImpl;
import com.graminmart.app.domain.inventory.ItemUnit;

@Repository("itemUnitDao")
public class ItemUnitDaoImpl extends GenericDaoImpl<ItemUnit, Integer> implements ItemUnitDao {

	@SuppressWarnings("unchecked")
	public ItemUnit findByCode(String code) {
		List<ItemUnit> itemUnits = em.createQuery("SELECT u FROM ItemUnit u WHERE u.code = ?1")
				.setParameter(1, code)
				.getResultList();
		if(!itemUnits.isEmpty())
			return itemUnits.get(0);
		else
			return null;
	}

}
