package com.eparchuniya.app.controller;

import java.io.Serializable;

public class EmployeeRequest implements Serializable {
	
	private String firstName;
	
	private String lastName;
	
	private SubRequest subRequest;

	public EmployeeRequest() {
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

	public SubRequest getSubRequest() {
		return subRequest;
	}

	public void setSubRequest(SubRequest subRequest) {
		this.subRequest = subRequest;
	}
	
	

}
