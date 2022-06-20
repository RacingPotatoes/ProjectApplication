package com.poc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.dto.RequestDTO;
import com.poc.mapper.CartMapper;

@Component
public class CartServiceValidator {

	@Autowired
	CartMapper mapper;
	
	public void checkCartExistence(Integer cartid, RequestDTO request) throws Exception {
		if(mapper.checkCartExistence(cartid, request.getOwnerEmail()) <=0) {
			System.out.println("validate");
			throw new Exception("Something went wrong! Cart does not exist!");
		}
	}
	
	public void checkProductExistence(Integer product_id) throws Exception {
		if(mapper.checkProductExistence(product_id) <= 0) {
			throw new Exception("Something went wrong! Product does not Exist!");
		}
	}
}
