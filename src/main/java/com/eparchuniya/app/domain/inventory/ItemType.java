package com.eparchuniya.app.domain.inventory;

import java.sql.Timestamp;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eparchuniya.app.domain.admin.User;
import com.eparchuniya.app.domain.base.BaseDomain;

@Entity
@Table(name = "inventory_item_type")
public class ItemType extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7891727008639447122L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_id")
	private int typeId;
	
	@Size(max = 20, message = "ItemType code cann't be greater than 20 characters")
	@NotEmpty(message = "ItemType code cann't be empty")
	@NotNull(message = "ItemType code cann't be null")
	@Column(name = "code", nullable = false, length = 20)
	private String code;
	
	@Size(max = 255, message = "ItemType display Name cann't be greater than 255 characters")
	@NotEmpty(message = "ItemType display Name cann't be empty")
	@NotNull(message = "ItemType display Name cann't be null")
	@Column(name = "display_name", nullable = false, length = 255)
	private String displayName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_ts", nullable = false)
	private Date createdTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_ts")
	private Date modifiedTs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by")
	private User modifiedBy;

	public ItemType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
