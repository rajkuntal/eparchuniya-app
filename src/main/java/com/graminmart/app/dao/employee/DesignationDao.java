package com.graminmart.app.dao.employee;

import com.graminmart.app.dao.generic.GenericDoa;
import com.graminmart.app.domain.employee.Designation;

public interface DesignationDao extends GenericDoa<Designation, Integer>{
	
	Designation findByName(String name);
	
}
