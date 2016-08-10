package com.eparchuniya.app.domain.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eparchuniya.app.domain.admin.LocationServed;
import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "cust_address")
public class CustomerAddress extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6318245983363058612L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long addressId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "customer_id", nullable = false)
	private Customer customer;
	
	@Size(max = 20, message = "houseNumber can not be greater than 20")
	@Column(name = "house_number", length = 20)
	private String houseNumber;
	
	@Size(max = 50, message = "colony can not be greater than 50")
	@NotEmpty(message = "Address colony can't be empty")
	@NotNull(message = "Address colony can't be null")
	@Column(name = "colony", nullable = false, length = 50)
	private String colony;
	
	@Size(max = 100, message = "street1 can not be greater than 100")
	@Column(name = "street", length = 100)
	private String street1;
	
	@Column(name = "ward_number")
	private int wardNumber;
	
	@Size(max = 100, message = "landmark can not be greater than 100")
	@Column(name = "landmark", length = 100)
	private String landmark;
	
	@Size(max = 100, message = "villageCity can not be greater than 100")
	@NotEmpty(message = "Address village/City can't be empty")
	@NotNull(message = "Address village/City can't be null")
	@Column(name = "village_city", nullable = false, length = 100)
	private String villageCity;
	
	@Size(max = 100, message = "tehsil can not be greater than 100")
	@NotEmpty(message = "Address tehsil can't be empty")
	@NotNull(message = "Address tehsil can't be null")
	@Column(name = "tehsil", nullable = false, length = 100)
	private String tehsil;
	
	@Size(max = 100, message = "district can not be greater than 100")
	@NotEmpty(message = "Address district can't be empty")
	@NotNull(message = "Address district can't be null")
	@Column(name = "District", nullable = false, length = 100)
	private String district;
	
	@Size(max = 100, message = "state can not be greater than 100")
	@NotEmpty(message = "Address state can't be empty")
	@NotNull(message = "Address state can't be null")
	@Column(name = "state", nullable = false, length = 100)
	private String state;
	
	@Column(name = "pincode", nullable = false)
	private Long pincode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	private LocationServed locationServed;
	
	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name="longitudes")
	private Double longitudes;
	
	@Column(name = "created_at", nullable = false)
	private Date createdTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Column(name = "modified_at")
	private Date modifiedTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by")
	private User modifiedBy;

	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}


	public int getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(int wardNumber) {
		this.wardNumber = wardNumber;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getVillageCity() {
		return villageCity;
	}

	public void setVillageCity(String villageCity) {
		this.villageCity = villageCity;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public LocationServed getLocationServed() {
		return locationServed;
	}

	public void setLocationServed(LocationServed locationServed) {
		this.locationServed = locationServed;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitudes() {
		return longitudes;
	}

	public void setLongitudes(Double longitudes) {
		this.longitudes = longitudes;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User	 modifiedBy) {
		this.modifiedBy = modifiedBy;
	}	

}
