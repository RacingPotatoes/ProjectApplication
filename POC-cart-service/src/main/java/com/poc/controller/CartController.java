package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dto.CartResponseDTO;
import com.poc.dto.RequestDTO;
import com.poc.dto.ResponseDTO;
import com.poc.entity.Cart;
import com.poc.mapper.CartMapper;
import com.poc.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService service;

	@PostMapping("/create")
	public Cart createCart(@RequestBody Cart cart) {
		return service.insertCart(cart);
	}
//
//	@GetMapping("/list")
//	public List<Cart> getAllUsers() {
//		return service.getList();
//	}

	@DeleteMapping("/delete/{id}")
	public Object deleteCart(@PathVariable Integer id, @RequestBody RequestDTO requestDTO) {
		return service.deleteItem(id, requestDTO);
	}
	
	@GetMapping("/view/mycart/{id}")
	public Object viewMyCart(@PathVariable Integer id, @RequestBody RequestDTO request) {
		return service.viewMyCart(id, request.getOwnerEmail());
	}

//	@PutMapping("/update/{id}")
//	public Cart updateCart(@PathVariable Integer id, @RequestBody Cart cart){
//	return service.editCart(id, cart);
//	}
	
	
	@PostMapping("/addtocart/{id}")
	public Object addToCart(@PathVariable Integer id, @RequestBody RequestDTO request) {
		return service.addToCart(id, request);
	}
}