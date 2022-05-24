package com.demo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "stock", catalog="demo")
public class Stock implements java.io.Serializable{




private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
@Column(name = "STOCK_ID", unique = true, nullable = false)
private int stockId;

@Column(name = "STOCK_CODE")
private String stockCode;

@Column(name = "STOCK_NAME")
private String stockName;

@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "stock_category", catalog = "demo", joinColumns = { 
		@JoinColumn(name = "STOCK_ID", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", 
				nullable = false, updatable = false) })
private Set<Category> categories = new HashSet<Category>(0);


//private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);
//private StockDetail stockDetail;

public Stock() {
}

public Stock(String stockCode, String stockName) {
	this.stockCode = stockCode;
	this.stockName = stockName;
}
public Stock(String stockCode, String stockName, Set<Category> categories) {
	this.stockCode = stockCode;
	this.stockName = stockName;
	this.setCategories(categories);
}

/*public Stock(String stockCode, String stockName,
		Set<StockDailyRecord> stockDailyRecords) {
	this.stockCode = stockCode;
	this.stockName = stockName;
	this.stockDailyRecords = stockDailyRecords;
}

public Stock(String stockCode, String stockName, StockDetail stockDetail) {
	this.stockCode = stockCode;
	this.stockName = stockName;
	this.stockDetail = stockDetail;
}*/


public int getStockId() {
    return stockId;
}

public void setStockId(int stockId) {
    this.stockId = stockId;
}

public String getStockCode() {
    return stockCode;
}

public void setStockCode(String stockCode) {
    this.stockCode = stockCode;
}

public String getStockName() {
    return stockName;
}

public void setStockName(String stockName) {
    this.stockName = stockName;
}
/*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="stock")
@PrimaryKeyJoinColumn
public StockDetail getStockDetail() {
	return stockDetail;
}

public void setStockDetail(StockDetail stockDetail) {
	this.stockDetail = stockDetail;
}
*/
/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
public Set<StockDailyRecord> getStockDailyRecords() {
	return stockDailyRecords;
}

public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
	this.stockDailyRecords = stockDailyRecords;
}*/

public Set<Category> getCategories() {
	return categories;
}

public void setCategories(Set<Category> categories) {
	this.categories = categories;
}


}
