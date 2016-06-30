package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_summary")
public class OrderSummary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 448223098152771991L;

	@Id
	@GenericGenerator(name = "order_id", strategy="com.eparchuniya.app.domain.common.util.OrderIdGenerator")
	@GeneratedValue(generator = "order_id")
	private String orderId;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	@ManyToOne
	@JoinColumn(name = "cust_address_id")
	private EmployeeAddress employeeAddress;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private OrderStatus orderStatus;
	

	public OrderSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
