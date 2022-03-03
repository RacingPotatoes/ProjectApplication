package com.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long pid;
	@Column(name = "PRODUCT_BRAND")
	private String pBrand;
	@Column(name = "PRODUCT_NAME")
	private String pName;
	@Column(name = "PRICE")
	private float price;
	@Column(name = "QUANTITY")
	private int pQty;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Long pid, String pBrand, String pName, float price, int pQty) {
		super();
		this.pid = pid;
		this.pBrand = pBrand;
		this.pName = pName;
		this.price = price;
		this.pQty = pQty;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pBrand=" + pBrand + ", pName=" + pName + ", price=" + price + ", pQty="
				+ pQty + "]";
	}
	
}
