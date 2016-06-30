package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ShipmentRoutePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4021810544655936288L;

	@ManyToOne
	@JoinColumn(name = "shipment_id")
	private ShipmentSummary shipmentId;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private ServedLocation locationId;

}
