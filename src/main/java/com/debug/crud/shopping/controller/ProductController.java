package com.debug.crud.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.debug.crud.shopping.Util.CollectionsUtils;
import com.debug.crud.shopping.entity.ProductEntity;
import com.debug.crud.shopping.repository.ProductRepository;

@RestController
public class ProductController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/product")
	public void creatProduct(@RequestBody ProductEntity product) {
		productRepository.save(product);

	}

	@GetMapping("/get-product")
	public List<ProductEntity> getProduct() {
		List<ProductEntity> findAll = productRepository.findAll();
		if (!CollectionsUtils.isEmpty(findAll)) {
			return findAll;
		}
		return null;

	}

	@GetMapping("/get-product/{id}")
	public ProductEntity getProductById(@PathVariable Integer id) {
		LOGGER.info("calling get Api for Product");
		Optional<ProductEntity> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@DeleteMapping("/delete-product/{id}")
	public String deleteProductById(@PathVariable Integer id) {
		Optional<ProductEntity> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			productRepository.delete(findById.get());
			getProduct();
			return "Successfully delete the product with Id: {}";
		
		} else {
			LOGGER.info("product not found with given product Id "+ id);
			return "Product Not Available with given Product Id: {}";
		}
	}

}
