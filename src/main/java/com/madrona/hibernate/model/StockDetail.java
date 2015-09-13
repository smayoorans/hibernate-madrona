package com.madrona.hibernate.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_detail")
public class StockDetail implements java.io.Serializable {

	private Long stockId;
	private Stock stock;
	private String compName;
	private String compDesc;
	private String remark;
	private Date listedDate;

	public StockDetail() {
	}

	public StockDetail(Stock stock, String compName, String compDesc,
			String remark, Date listedDate) {
		this.stock = stock;
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "stock"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "stock_id", unique = true, nullable = false)
	public Long getStockId() {
		return this.stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Column(name = "comp_name", nullable = false, length = 100)
	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Column(name = "comp_desc", nullable = false)
	public String getCompDesc() {
		return this.compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "listed_date", nullable = false, length = 10)
	public Date getListedDate() {
		return this.listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	@Override
	public String toString() {
		return "StockDetail{" +
				"stockId=" + stockId +
				", stock=" + stock +
				", compName='" + compName + '\'' +
				", compDesc='" + compDesc + '\'' +
				", remark='" + remark + '\'' +
				", listedDate=" + listedDate +
				'}';
	}
}
