package com.eparchuniya.app.domain.inventory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eparchuniya.app.domain.admin.User;

@Entity
@Table(name = "stock_credit_summary")
public class StockCreditSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1435220546463694101L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id")
	private Long stockId;
	
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@Column(name = "comments", length = 255)
	private String comments;
	
	@Column(name = "submitted_at", nullable = false)
	private Timestamp submittedAt;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "submitted_by")
	private User submittedBy;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="stockCreditDetailPK.stockCreditSummary")
	private Set<StockCreditDetail> stockCreditDetails;

	public StockCreditSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Timestamp submittedAt) {
		this.submittedAt = submittedAt;
	}

	public User getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(User submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Set<StockCreditDetail> getStockCreditDetails() {
		return stockCreditDetails;
	}

	public void setStockCreditDetails(Set<StockCreditDetail> stockCreditDetails) {
		this.stockCreditDetails = stockCreditDetails;
	}

}
