package com.eparchuniya.app.domain.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "emp_address")
public class EmployeeAddress extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5213787820263578162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_address_id")
	private int empAddressId;
	
	@Column(name = "house_number", length = 20)
	private String houseNumber;
	
	@NotNull(message = "EmployeeAddress colony can't be empty")
	@Column(name = "colony", nullable = false, length = 50)
	private String colony;
	
	@Column(name = "street", length = 100)
	private String street1;
	
	@Column(name = "ward_number")
	private int wardNumber;
	
	@Column(name = "landmark", length = 50)
	private String landmark;
	
	@NotNull(message = "EmployeeAddress village/City can't be empty")
	@Column(name = "village_city", nullable = false)
	private String villageCity;
	
	@NotNull(message = "EmployeeAddress tehsil can't be empty")
	@Column(name = "tehsil", nullable = false, length = 100)
	private String tehsil;
	
	@NotNull(message = "EmployeeAddress district can't be empty")
	@Column(name = "District", nullable = false, length = 100)
	private String district;
	
	@NotNull(message = "EmployeeAddress state can't be empty")
	@Column(name = "state", nullable = false, length = 100)
	private String state;
	
	@NotNull(message = "EmployeeAddress pincode can't be empty")
	@Column(name = "pincode", nullable = false)
	private Long pincode;
	
	@OneToOne(mappedBy = "employeeAddress")
	private Employee employee;
	
	public EmployeeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpAddressId() {
		return empAddressId;
	}

	public void setEmpAddressId(int empAddressId) {
		this.empAddressId = empAddressId;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


}
