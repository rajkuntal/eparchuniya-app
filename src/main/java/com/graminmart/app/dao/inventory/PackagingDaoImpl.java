package com.graminmart.app.dao.inventory;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.graminmart.app.dao.generic.GenericDaoImpl;
import com.graminmart.app.domain.inventory.Packaging;

@Repository("packagingDao")
public class PackagingDaoImpl extends GenericDaoImpl<Packaging, Integer> implements PackagingDao {

	public boolean enablePackaging(int packagingId, int modifiedBy) {
		em.createNativeQuery("UPDATE inventory_packaging SET enabled=1, modified_by = ?1, modified_ts = ?2 WHERE packaging_id = ?3")
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, packagingId)
		.executeUpdate();
		return true;
	}

	public boolean disablePackaging(int packagingId, int modifiedBy) {
		em.createNativeQuery("UPDATE inventory_packaging SET enabled=0, modified_by = ?1, modified_ts = ?2 WHERE packaging_id = ?3")
		.setParameter(1, modifiedBy)
		.setParameter(2, new Date())
		.setParameter(3, packagingId)
		.executeUpdate();
		return true;
	}

}
