package com.eparchuniya.app.dao;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer> implements EmployeeDao {

}
