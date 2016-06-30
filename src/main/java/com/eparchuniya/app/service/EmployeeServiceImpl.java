package com.eparchuniya.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eparchuniya.app.dao.EmployeeDao;
import com.eparchuniya.app.domain.Employee;

 
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDao dao;
     
    public Employee findById(int id) {
        return dao.findById(id);
    }
 
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateEmployee(Employee employee) {
        Employee entity = dao.findById(employee.getEmployeeId());
        if(entity!=null){
            entity.setFirstName(employee.getFirstName());
        }
    }
 
    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }
     
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }
 
    public Employee findEmployeeBySsn(String ssn) {
        return dao.findEmployeeBySsn(ssn);
    }
 
    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
    	return true;
    	//implementation
    }
     
}
