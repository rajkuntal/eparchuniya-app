package com.eparchuniya.app.domain.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -580520328058592703L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int statusId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "status_flow")
	private int statusFlow;

	public OrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatusFlow() {
		return statusFlow;
	}

	public void setStatusFlow(int statusFlow) {
		this.statusFlow = statusFlow;
	}

}
