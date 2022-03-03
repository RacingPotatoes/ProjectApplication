package com.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.entity.Products;
import com.poc.exception.NotFoundException;

@Service
public interface ProductsService {

	public Products updateProduct(Long pid, Products product);

	public Products saveProduct(Products product);

	public Products findByPid(Long pid) throws NotFoundException;

//	public Products findByPName(String pName);

	public List<Products> findAllProducts();

	public List<Products> deleteProduct(Long pid);
}
