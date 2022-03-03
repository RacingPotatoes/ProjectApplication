package com.poc.DTO;

public class ProductsRequestDTO {
	private String pBrand;
	private String pName;
	private float price;
	private int pQty;

	public ProductsRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsRequestDTO(String pBrand, String pName, float price, int pQty) {
		super();
		this.pBrand = pBrand;
		this.pName = pName;
		this.price = price;
		this.pQty = pQty;
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

}
