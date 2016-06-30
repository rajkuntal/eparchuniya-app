package com.eparchuniya.app.controller;

import java.io.Serializable;

public class SubRequest implements Serializable {
	
	private int id;
	private String name;
	
	
	public SubRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
