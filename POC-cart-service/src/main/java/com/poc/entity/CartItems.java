package com.poc.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {

	private Integer cartItemId;
	private Integer cartId;
	private String ownerEmail;
	private Integer product_id;
	private String product_name;
	private float price;
	private int order_qty;
	private float order_subtotal;
}
