package com.eparchuniya.app.domain.shipment;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eparchuniya.app.domain.ServedLocation;

@Embeddable
public class RoutePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4021810544655936288L;

	@ManyToOne
	@JoinColumn(name = "shipment_id")
	private Shipment shipmentId;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private ServedLocation locationId;

	public RoutePK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shipment getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(Shipment shipmentId) {
		this.shipmentId = shipmentId;
	}

	public ServedLocation getLocationId() {
		return locationId;
	}

	public void setLocationId(ServedLocation locationId) {
		this.locationId = locationId;
	}

}
