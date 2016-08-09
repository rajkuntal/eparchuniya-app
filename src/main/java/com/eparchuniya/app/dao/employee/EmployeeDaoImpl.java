package com.eparchuniya.app.dao.employee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.dao.generic.GenericDaoImpl;
import com.eparchuniya.app.domain.employee.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer> implements EmployeeDao {
	
	@SuppressWarnings("unchecked")
	public Employee findByMobileNumber(Long mobile) {
		List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.mobileNumber = ?1")
									.setParameter(1, mobile)
									.getResultList();
		if(!employees.isEmpty())
			return employees.get(0);
		else
			return null;
	}
}
