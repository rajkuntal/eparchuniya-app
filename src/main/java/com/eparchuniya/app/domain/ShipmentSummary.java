package com.eparchuniya.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "shipment_summary")
public class ShipmentSummary implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2720577993409435436L;

	@Id
	@GenericGenerator(name = "shipment_id", strategy="com.eparchuniya.app.common.util.ShipmentIdGenerator")
	@GeneratedValue(generator = "shipment_id")
	@Column(name = "shipment_id")
	private String shipmentId;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private ShipmentStatus shipmentStatus;
	
	@ManyToOne
	@JoinColumn(name = "assigned_emp_id")
	private Employee assignedEmpId;
	
	@Column(name = "total_amount")
	private Double totalAmount;
	
	@Column(name = "amount_to_emp")
	private Double amountToEmp;
	
	@Column(name = "final_amount")
	private Double finalAmount;
	
	@Column(name = "created_at")
	private Timestamp createdTs;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@Column(name = "modified_at")
	private Timestamp modifiedTs;
	
	@ManyToOne
	@JoinColumn(name = "modified_by")
	private User modifiedBy;
	
	@Column(name = "initiated_at")
	private Timestamp initiatedTs;
	
	@ManyToOne
	@JoinColumn(name = "initiated_by")
	private User initiatedBy;
	
	@Column(name = "completed_at")
	private Timestamp completedAt;
	
	@ManyToOne
	@JoinColumn(name = "completed_by")
	private User completedBy;

	public ShipmentSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public Employee getAssignedEmpId() {
		return assignedEmpId;
	}

	public void setAssignedEmpId(Employee assignedEmpId) {
		this.assignedEmpId = assignedEmpId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAmountToEmp() {
		return amountToEmp;
	}

	public void setAmountToEmp(Double amountToEmp) {
		this.amountToEmp = amountToEmp;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Timestamp getCreatedAt() {
		return createdTs;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdTs = createdAt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedAt() {
		return modifiedTs;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedTs = modifiedAt;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getInitiatedAt() {
		return initiatedTs;
	}

	public void setInitiatedAt(Timestamp initiatedAt) {
		this.initiatedTs = initiatedAt;
	}

	public User getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(User initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public Timestamp getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Timestamp completedAt) {
		this.completedAt = completedAt;
	}

	public User getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(User completedBy) {
		this.completedBy = completedBy;
	}

}
