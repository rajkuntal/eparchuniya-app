package com.eparchuniya.app.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eparchuniya.app.domain.Designation;
import com.eparchuniya.app.domain.Employee;
import com.eparchuniya.app.domain.EmployeeAddress;
import com.eparchuniya.app.domain.Store;

@Transactional
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
//	private final Class<Employee> persistentClass;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private StoreDao StoreDao;
	
	@Autowired
	private DesignationDao designationDao;
	
	@Autowired
	private EmployeeAddressDao employeeAddressDao;
	
//	@SuppressWarnings("unchecked")
//    public EmployeeDaoImpl(){
//        this.persistentClass =(Class<Employee>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//    }
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
	@SuppressWarnings("unchecked")
    public Employee findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Employee)session.get(Employee.class, id);
    }
 
//    public void saveEmployee(Employee employee) {
//        persist(employee);
//    }
 
    public void deleteEmployeeBySsn(Long mobileNumber) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("delete from Employee where mobileNumber = :mobileNumber");
        query.setLong("mobileNumber", mobileNumber);
        query.executeUpdate();
    }
    
    public void saveEmployee(Employee employee) {
    	
    	java.sql.Timestamp timeStamp = new java.sql.Timestamp(new java.util.Date().getTime());
    	
    	employee.setCreatedTs(timeStamp);
    	employee.setModifiedTs(timeStamp);
    	employee.setIsActive(false);
    	employee.setJoiningDate(timeStamp);
    	
    	Store store = StoreDao.findById(1);
    	Designation designation = designationDao.findById(1);
    	EmployeeAddress employeeAddress = employeeAddressDao.findById(1);
    	
    	employee.setStore(store);
    	employee.setDesignation(designation);
    	employee.setEmployeeAddress(employeeAddress);
    	
    	sessionFactory.getCurrentSession().persist(employee);
    	
    }
 
//    @SuppressWarnings("unchecked")
//    public List<Employee> findAllEmployees() {
//        Criteria criteria = createEntityCriteria();
//        return (List<Employee>) criteria.list();
//    }
// 
//    public Employee findEmployeeBySsn(Long mobileNumber) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("mobileNumber", mobileNumber));
//        return (Employee) criteria.uniqueResult();
//    }

	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		
	}

	public Employee findEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
}