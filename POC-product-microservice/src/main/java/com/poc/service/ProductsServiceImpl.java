package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.Products;
import com.poc.exception.NotFoundException;
import com.poc.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public Products saveProduct(Products product) {
		return productsRepository.save(product);
	}

	@Override
	public Products updateProduct(Long pid, Products product) {

		Products existingProduct = productsRepository.findById(pid).get();

		existingProduct.setpBrand(product.getpBrand());
		existingProduct.setpName(product.getpName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setpQty(product.getpQty());
		return productsRepository.save(existingProduct);
	}

	@Override
	public Products findByPid(Long pid) throws NotFoundException {
		return productsRepository.findById(pid).orElseThrow(() -> new NotFoundException("Product Not Found!"));
	}

	@Override
	public List<Products> findAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public List<Products> deleteProduct(Long pid) {
		productsRepository.deleteById(pid);
		return productsRepository.findAll();
	}

	private List<Products> products;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

}
