package com.madrona.hibernate.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "stock", uniqueConstraints = {
        @UniqueConstraint(columnNames = "stock_name"),
        @UniqueConstraint(columnNames = "stock_code")})
public class Stock implements java.io.Serializable {

    private Long stockId;
    private String stockCode;
    private String stockName;
    private StockDetail stockDetail;

    public Stock() {
    }

    public Stock(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "stock_id", unique = true, nullable = false)
    public Long getStockId() {
        return this.stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Column(name = "stock_code", unique = true, nullable = false, length = 10)
    public String getStockCode() {
        return this.stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "stock_name", unique = true, nullable = false, length = 20)
    public String getStockName() {
        return this.stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
    public StockDetail getStockDetail() {
        return this.stockDetail;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockDetail=" + stockDetail +
                '}';
    }
}
