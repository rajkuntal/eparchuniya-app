package com.eparchuniya.app.domain.shipment;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eparchuniya.app.domain.ServedLocation;

@Embeddable
public class RoutePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4021810544655936288L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "shipment_id", nullable = false)
	private Shipment shipmentId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
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
