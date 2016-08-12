package com.graminmart.app.domain.example;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exml_employee_address")
public class EmpAddress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5475129536485653114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	private String colony;
	
	
	public EmpAddress() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getAddId() {
		return addId;
	}


	public void setAddId(int addId) {
		this.addId = addId;
	}


	public String getColony() {
		return colony;
	}


	public void setColony(String colony) {
		this.colony = colony;
	}

}
