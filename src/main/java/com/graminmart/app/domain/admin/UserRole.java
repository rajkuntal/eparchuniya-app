package com.graminmart.app.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.graminmart.app.domain.base.BaseDomain;

@Entity
@Table(name = "admin_user_role")
public class UserRole extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7202380909792102372L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role_type", length = 50, nullable = false)
	private String roleType;

	@Column(name = "dispaly_name", length = 50, nullable = false)
	private String displayName;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
