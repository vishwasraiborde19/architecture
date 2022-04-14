package com.ecom.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.domain.Product;
import com.ecom.product.service.ProductService;

@RestController("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/categories")
	public List<Product> getProductsCategories() {
		return productService.getProductsCategories();
	}
	
	@GetMapping("/{catID}/products")
	public List<Product> getProductsByCategory(@RequestParam Long catID) {
		return productService.getProductsByCategory(catID);
	}
	
	@GetMapping("/")
	public List<Product> getProducts() {
		return productService.productService();
	}
	
	@GetMapping("/{productID}")
	public Optional<Product> getProduct(@RequestParam Long productID) {
		return productService.getProduct(productID);
	}
	
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@DeleteMapping("/productID")
	public Product deleteProduct(@RequestParam Long productID) {
		return productService.deleteProduct(productID);
	}

}
