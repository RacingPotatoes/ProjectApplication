package com.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Integer product_id;
	private String product_brand;
	private String product_name;
	private Integer quantity;
	private float price;
}
