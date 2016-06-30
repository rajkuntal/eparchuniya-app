package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shipment_route")
public class ShipmentRoute implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5375649595038596004L;
	
	@EmbeddedId
	private ShipmentRoutePK shipmentRoutePK;
	
	@Column(name = "route_priority")
	private int routePriority;
	
	@Column(name = "additional_params")
	private String additionalParams;

	public ShipmentRoute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShipmentRoutePK getShipmentRoutePK() {
		return shipmentRoutePK;
	}

	public void setShipmentRoutePK(ShipmentRoutePK shipmentRoutePK) {
		this.shipmentRoutePK = shipmentRoutePK;
	}

	public int getRoutePriority() {
		return routePriority;
	}

	public void setRoutePriority(int routePriority) {
		this.routePriority = routePriority;
	}

	public String getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String additionalParams) {
		this.additionalParams = additionalParams;
	}

}
