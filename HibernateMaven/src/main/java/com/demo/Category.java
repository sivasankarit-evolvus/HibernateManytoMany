package com.demo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog = "demo")
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private int categoryId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESC")
	private String desc;
	 @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Stock> stocks = new HashSet<Stock>(0);
	public Category() {
	}

	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	
	  public Category(String name, String desc, Set<Stock> stocks) { 
		  this.name =name; 
		  this.desc = desc; 
		  this.stocks = stocks; 
	}
	 
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	 
	  public Set<Stock> getStocks() { 
		  return stocks; 
	} 
	  public void setStocks(Set<Stock> stocks) { 
		  this.stocks = stocks;
	  }
	 
	
}
