package com.eparchuniya.app.domain;

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
import javax.validation.constraints.NotNull;

import com.eparchuniya.app.domain.basedomain.BaseDomain;

@Entity
@Table(name = "cust_address")
public class CustomerAddress extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6318245983363058612L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_address_id")
	private int custAddressId;
	
	@Column(name = "house_number", length = 20)
	private String houseNumber;
	
	@NotNull(message = "{CustomerAddress.colony can't be null}")
	@Column(name = "colony", nullable = false, length = 50)
	private String colony;
	
	@Column(name = "street", length = 100)
	private String street1;
	
	@Column(name = "ward_number")
	private int wardNumber;
	
	@Column(name = "landmark", length = 100)
	private String landmark;
	
	@NotNull(message = "{CustomerAddress.villageCity can't be null}")
	@Column(name = "village_city", nullable = false)
	private String villageCity;
	
	@NotNull(message = "{CustomerAddress.tehsil can't be null}")
	@Column(name = "tehsil", nullable = false, length = 100)
	private String tehsil;
	
	@NotNull(message = "{CustomerAddress.district can't be null}")
	@Column(name = "District", nullable = false, length = 100)
	private String district;
	
	@NotNull(message = "{CustomerAddress.state can't be null}")
	@Column(name = "state", nullable = false, length = 100)
	private String state;
	
	@NotNull(message = "{CustomerAddress.pincode can't be null}")
	@Column(name = "pincode", nullable = false)
	private Long pincode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	private LocationServed locationServed;
	
	@NotNull(message = "{CustomerAddress.isActive can't be null}")
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

	public int getCustAddressId() {
		return custAddressId;
	}

	public void setCustAddressId(int custAddressId) {
		this.custAddressId = custAddressId;
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

	public Boolean getIsActive() {
		return enabled;
	}

	public void setIsActive(Boolean isActive) {
		this.enabled = isActive;
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

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}	

}
