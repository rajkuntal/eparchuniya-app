package com.eparchuniya.app.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adm_customer_address_mapping")
public class CustomerAddressMapping implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9046191034767385250L;
	@EmbeddedId
	private CustomerAddressMappingPK customerAddressMappingPK;

	public CustomerAddressMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAddressMappingPK getCustomerAddressMappingPK() {
		return customerAddressMappingPK;
	}

	public void setCustomerAddressMappingPK(CustomerAddressMappingPK customerAddressMappingPK) {
		this.customerAddressMappingPK = customerAddressMappingPK;
	}

}
