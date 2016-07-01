package com.eparchuniya.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eparchuniya.app.domain.order.OrderSummary;

@Transactional
@Repository("orderSummaryDao")
public class OrderSummaryDaoImpl implements OrderSummaryDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addOrderSummary(OrderSummary orderSummary) {
		sessionFactory.getCurrentSession().save(orderSummary);
		
	}

}
