package com.poc.config;

import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.poc.ClientApplication;
import com.poc.DTO.ProductsRequestDTO;
import com.poc.DTO.ProductsResponseDTO;
import com.poc.stub.ProductsResponse;

public class ClientConfig {
	private static final String PRODUCTS_URL = "http://localhost:8081/ecz/products";
	private static final RestTemplate restTemplate = new RestTemplate();
	public static Scanner scanner = new Scanner(System.in);
	private static ProductsResponse productsResponse;

	public static void viewProducts() {
		productsResponse = restTemplate.getForObject(PRODUCTS_URL + "/lists", ProductsResponse.class);
		List<ProductsResponseDTO> products = productsResponse.getProducts();
		for (ProductsResponseDTO getProducts : products) {
			System.out.println("*********************************");

			System.out.println("Product Brand: " + getProducts.getpBrand());

			System.out.println("Product Name: " + getProducts.getpName());

			System.out.println("Price: " + getProducts.getPrice());

			System.out.println("Stock Left: " + getProducts.getpQty());
		}
		System.out.println("Do you want to edit your stock? [Y] | [N]");
		String answer = scanner.next();
		if (answer.equalsIgnoreCase("y")) {

			searchProduct();
		}
		if (answer.equalsIgnoreCase("n")) {
			ClientApplication.main(null);
		} else {
			System.out.println("INVALID FORMAT! PROGRAM SHUTTING DOWN!");
		}
	}

	public static void searchProduct() {
		System.out.println("Search ID : ");
		Long searchIdLong = scanner.nextLong();
		try {
			productsResponse = restTemplate.getForObject(PRODUCTS_URL + "/get/id/" + searchIdLong,
					ProductsResponse.class);
			ProductsResponseDTO dto = productsResponse.getProductResponseDTO();
			editProduct(dto);
		} catch (Exception e) {
			System.out.println("Product Not Found!");
			searchProduct();
		}
	}

	public void addProduct() {
		System.out.println("Add new Product");

		System.out.print("Enter Product Brand: ");
		String setProductBrand = scanner.next() + scanner.nextLine();

		System.out.print("Enter Product Name: ");
		String setProductName = scanner.next() + scanner.nextLine();

		System.out.print("Enter Product Price: ");
		float setProductPrice = scanner.nextFloat();

		System.out.print("Enter Product Quantity: ");
		int setProductQty = scanner.nextInt();

		ProductsRequestDTO requestDTO = new ProductsRequestDTO();

		requestDTO.setpBrand(setProductBrand);
		requestDTO.setpName(setProductName);
		requestDTO.setPrice(setProductPrice);
		requestDTO.setpQty(setProductQty);
		System.out.println();
		System.out.println("Product Information");
		System.out.println("Product Brand       : " + requestDTO.getpBrand());
		System.out.println("Product Name        : " + requestDTO.getpName());
		System.out.println("Product Price       : " + requestDTO.getPrice());
		System.out.println("Product Quanity     : " + requestDTO.getpQty());

		System.out.println("Add this product to your list? [Y] | [N]");
		String answer = scanner.next();
		switch (answer.toLowerCase()) {
		case "y":
			System.out.println("Successfully Added!");
			restTemplate.postForObject(PRODUCTS_URL + "/add", requestDTO, ProductsResponseDTO.class);
			ClientApplication.main(null);
			break;
		case "n":
			System.out.println("Cancelled!");
			ClientApplication.main(null);
			break;
		default:
			break;
		}
	}

	public static void editProduct(ProductsResponseDTO dto) {
		System.out.println("[1]     Product Brand : " + dto.getpBrand());
		System.out.println("[2]     Product Name  : " + dto.getpName());
		System.out.println("[3]     Product Price : " + dto.getPrice());
		System.out.println("[4]     Product Stock : " + dto.getpQty());

		System.out.println();
		System.out.print("Please choose an option : ");
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			System.out.println("Enter Product Brand : ");
			String productBrand = scanner.next() + scanner.nextLine();
			dto.setpBrand(productBrand);
			break;

		case 2:
			System.out.println("Enter Product Name : ");
			String productName = scanner.next() + scanner.nextLine();
			dto.setpName(productName);
			break;

		case 3:
			System.out.println("Enter Product Price : ");
			float productPrice = scanner.nextFloat();
			dto.setPrice(productPrice);
			break;
			
		case 4:
			System.out.println("Enter Product Stock : ");
			int productStock = scanner.nextInt();
			dto.setpQty(productStock);
			break;
			
		default:
			System.out.println("Invalid Input");
			editProduct(dto);
			break;
		}

		restTemplate.put(PRODUCTS_URL + "/update/id/" + dto.getPid(), dto, ProductsResponseDTO.class);
		System.out.println("Successfully Updated!");
		viewProducts();

	}
}
