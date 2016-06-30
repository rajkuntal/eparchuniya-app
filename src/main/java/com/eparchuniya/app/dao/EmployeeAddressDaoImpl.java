package com.eparchuniya.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eparchuniya.app.domain.EmployeeAddress;


@Transactional
@Repository("employeeAddressDao")
public class EmployeeAddressDaoImpl implements EmployeeAddressDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployeeAddress(EmployeeAddress employeeAddress) {
		
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(new java.util.Date().getTime());
		
		employeeAddress.setCreatedBY(1);
		employeeAddress.setModifiedBy(1);
		employeeAddress.setCreatedTs(timeStamp);
		employeeAddress.setModifiedTs(timeStamp);
		
		sessionFactory.getCurrentSession().save(employeeAddress);
		
	}

	public EmployeeAddress findById(int id) {
		return (EmployeeAddress) sessionFactory.getCurrentSession().get(EmployeeAddress.class, id);
	}

}
