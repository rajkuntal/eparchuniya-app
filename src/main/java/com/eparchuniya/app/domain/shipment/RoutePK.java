package com.eparchuniya.app.domain.shipment;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eparchuniya.app.domain.admin.LocationServed;

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
	private LocationServed locationId;

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

	public LocationServed getLocationId() {
		return locationId;
	}

	public void setLocationId(LocationServed locationId) {
		this.locationId = locationId;
	}

}
