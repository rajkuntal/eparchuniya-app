package com.eparchuniya.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eparchuniya.app.domain.basedomain.BaseDomain;

@Entity
@Table(name = "emp_designation")
public class Designation extends BaseDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7957709891458930891L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "designation_id")
	private int designationId;
	
	@NotNull(message = "{Designation.name can't be null}")
	@Size(max = 50, message = "{Designation.name max size 50}")
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
