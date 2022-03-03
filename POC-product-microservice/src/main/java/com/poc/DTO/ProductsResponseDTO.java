package com.poc.DTO;

public class ProductsResponseDTO {

	private Long pid;
	private String pBrand;
	private String pName;
	private float price;
	private int pQty;

	public ProductsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsResponseDTO(Long pid, String pBrand, String pName, float price, int pQty) {
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

}
