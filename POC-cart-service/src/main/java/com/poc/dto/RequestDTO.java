package com.poc.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

	private String ownerEmail;
	private Integer product_id;
	private int order_qty;
}
