package com.poc.controller;

import java.util.List;

import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.DTO.ProductsRequestDTO;
import com.poc.DTO.ProductsResponseDTO;
import com.poc.entity.Products;
import com.poc.exception.NotFoundException;
import com.poc.repository.ProductsRepository;
import com.poc.service.ProductsResponse;
import com.poc.service.ProductsServiceImpl;
import com.poc.util.EntityConverter;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	KafkaTemplate<String, String> kafkaTemp;
	
	@Bean
	public NewTopic creatingTopic() {
		return TopicBuilder.name("Products_Logs").build();
	}

	@Autowired
	ProductsRepository productsRepository;

	@Autowired
	ProductsServiceImpl productService;

	@Autowired
	EntityConverter entityConverter;

	private Products product;
	private ProductsResponseDTO responseDTO;
	private List<ProductsResponseDTO> responseListDto;

	@GetMapping("/lists")
	public ProductsResponse getDTOList() {
		List<Products> products = productService.findAllProducts();
		responseListDto = entityConverter.getAllProductsToDTO(products);
		ProductsResponse productResponse = new ProductsResponse();
		productResponse.setProducts(responseListDto);
		kafkaTemp.send("Products_Logs", "View Success!");
		return productResponse;
	}

	@PostMapping("/add")
	public ProductsResponseDTO saveProduct(@RequestBody ProductsRequestDTO request) {
		product = entityConverter.convertToProduct(request);
		productService.saveProduct(product);
		responseDTO = entityConverter.convertFromProduct(product);
		kafkaTemp.send("Products_Logs", "Added Successful: "+product);
		return responseDTO;
	}
	
	@GetMapping("/get/id/{id}")
	public ProductsResponse getProduct(@PathVariable("id") Long pid) throws NotFoundException {
		product = productService.findByPid(pid);
		responseDTO = entityConverter.convertFromProduct(product);
		ProductsResponse productsResponse = new ProductsResponse();
		productsResponse.setProductResponseDTO(responseDTO);
		return productsResponse;

	}

	@PutMapping("/update/id/{pid}")
	public ProductsResponseDTO updateProduct(@PathVariable("pid") Long pid, @RequestBody ProductsRequestDTO request)
			throws NotFoundException {
		Products productRequest = entityConverter.convertToProduct(request);
		product = productService.updateProduct(pid, productRequest);
		responseDTO = entityConverter.convertFromProduct(product);
		kafkaTemp.send("Products_Logs", "Edit Successful: "+product);
		return responseDTO;
	}

}
