package com.graminmart.app.domain.shipment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shipment_route")
public class Route implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5375649595038596004L;
	
	@EmbeddedId
	private RoutePK routePK;
	
	@Column(name = "route_priority")
	private int routePriority;
	
	@Column(name = "additional_params", length = 1000)
	private String additionalParams;

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RoutePK getRoutePK() {
		return routePK;
	}


	public void setRoutePK(RoutePK routePK) {
		this.routePK = routePK;
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
