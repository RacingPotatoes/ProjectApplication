package com.poc.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.poc.DTO.ProductsRequestDTO;
import com.poc.DTO.ProductsResponseDTO;
import com.poc.entity.Products;

@Component
public class EntityConverter {

	public Products convertToProduct(ProductsRequestDTO request) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(request, Products.class);
	}

	public ProductsResponseDTO convertFromProduct(Products product) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(product, ProductsResponseDTO.class);
	}

	public List<ProductsResponseDTO> getAllProductsToDTO(List<Products> product) {
		return product.stream().map(this::convertFromProduct).collect(Collectors.toList());
	}
}

//	public Products convertToProduct(ProductsRequestDTO request) {
//		Products product = new Products();
//		product.setpBrand(request.getpBrand());
//		product.setpName(request.getpName());
//		product.setPrice(request.getPrice());
//		product.setpQty(request.getpQty());
//		return product;
//	}
//
//	public ProductsResponseDTO convertFromProduct(Products product) {
//		ProductsResponseDTO response = new ProductsResponseDTO();
//		response.setPid(product.getPid());
//		response.setpBrand(product.getpBrand());
//		response.setpName(product.getpName());
//		response.setPrice(product.getPrice());
//		response.setpQty(product.getpQty());
//		return response;
//	}
//
//	public List<ProductsResponseDTO> getAllProductsToDTO(List<Products> product) {
//		return product.stream().map(this::convertFromProduct).collect(Collectors.toList());
//	}
//
//}
