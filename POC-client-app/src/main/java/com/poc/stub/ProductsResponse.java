package com.poc.stub;

import java.util.List;

import com.poc.DTO.ProductsResponseDTO;

public class ProductsResponse {
	private ProductsResponseDTO productResponseDTO;

	private List<ProductsResponseDTO> products;

	public List<ProductsResponseDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsResponseDTO> products) {
		this.products = products;
	}
	
	public ProductsResponseDTO getProductResponseDTO() {
		return productResponseDTO;
	}

	public void setProductResponseDTO(ProductsResponseDTO productDTOResponse) {
		this.productResponseDTO = productDTOResponse;
	}

}
