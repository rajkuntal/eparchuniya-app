package com.eparchuniya.app.dao;

import com.eparchuniya.app.domain.Designation;

public interface DesignationDao {
	
	void addDesignation(Designation designation);
	
	public Designation findById(int id);

}
