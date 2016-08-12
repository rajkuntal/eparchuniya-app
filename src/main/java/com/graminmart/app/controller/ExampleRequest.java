package com.graminmart.app.controller;

import java.io.Serializable;

public class ExampleRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9098827000264824662L;

	private String firstName;
	
	private String lastName;
	
	private String colony1;
	
	private String colony2;
	
	private String colony3;
	
	private String dptName;
	
	private int deptId;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public ExampleRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getColony1() {
		return colony1;
	}

	public void setColony1(String colony1) {
		this.colony1 = colony1;
	}

	public String getColony2() {
		return colony2;
	}

	public void setColony2(String colony2) {
		this.colony2 = colony2;
	}

	public String getColony3() {
		return colony3;
	}

	public void setColony3(String colony3) {
		this.colony3 = colony3;
	}
	
	

}
