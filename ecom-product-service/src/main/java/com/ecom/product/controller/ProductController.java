package com.ecom.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.domain.Product;
import com.ecom.product.service.ProductService;

@RestController()
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
		
	@GetMapping
	public List<Product> getProducts() {
		return productService.productService();
	}
	
	@GetMapping("/{catId}")
	public Optional<List<Product>> getProductsByCategory(@PathVariable Integer catId) {
		return productService.getProductsByCategory(catId);
	}
	
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

}
