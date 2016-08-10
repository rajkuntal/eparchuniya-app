package com.eparchuniya.app.dao.employee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.employee.Designation;

@Repository("designationDao")
public class DesignationDaoImpl extends GenericDaoImpl<Designation, Integer> implements DesignationDao {

	@SuppressWarnings("unchecked")
	public Designation findByName(String name) {
		List<Designation> designations = em.createQuery("SELECT d FROM Designation d WHERE d.name = ?1")
						.setParameter(1, name)
						.getResultList();
		if(!designations.isEmpty())
			return designations.get(0);
		else
			return null;
	}
	
	

}
