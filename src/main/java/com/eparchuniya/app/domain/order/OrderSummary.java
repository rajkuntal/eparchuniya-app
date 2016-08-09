package com.eparchuniya.app.domain.order;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.eparchuniya.app.domain.admin.Store;
import com.eparchuniya.app.domain.customer.Customer;
import com.eparchuniya.app.domain.customer.CustomerMobile;
import com.eparchuniya.app.domain.employee.EmployeeAddress;
import com.eparchuniya.app.domain.shipment.Shipment;

@Entity
@Table(name = "order_summary")
public class OrderSummary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 448223098152771991L;

	@Id
	@GenericGenerator(name = "order_id", strategy="com.eparchuniya.app.common.util.OrderIdGenerator")
	@GeneratedValue(generator = "order_id")
	private String orderId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_address_id")
	private EmployeeAddress employeeAddress;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mobile_number")
	private CustomerMobile customerMobile;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "shipment_id")
	private Shipment shipment;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id")
	private OrderStatus orderStatus;
	
	@Column(name = "call_duration", nullable = false)
	private Double callDuration;
	
	@Column(name = "call_amount", nullable = false)
	private Double callAmount;
	
	@Column(name = "total_amount", nullable = false)
	private Double totalAmount;
	
	@Column(name = "final_amount", nullable = false)
	private Double finalAmount;
	
	public OrderSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(Double callDuration) {
		this.callDuration = callDuration;
	}

	public Double getCallAmount() {
		return callAmount;
	}

	public void setCallAmount(Double callAmount) {
		this.callAmount = callAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
