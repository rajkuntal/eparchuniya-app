package com.eparchuniya.app.dao.employee;

import com.eparchuniya.app.dao.generic.GenericDoa;
import com.eparchuniya.app.domain.employee.Designation;

public interface DesignationDao extends GenericDoa<Designation, Integer>{
	
	Designation findByName(String name);
	
}
