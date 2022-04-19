package com.ecom.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.domain.Product;
import com.ecom.product.service.ProductService;

@RestController()
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/categories")
	public List<Product> getProductsCategories() {
		return productService.getProductsCategories();
	}
	
	@GetMapping("/category/{id}/products")
	public List<Product> getProductsByCategory(@PathVariable Long id) {
		return productService.getProductsByCategory(id);
	}
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.productService();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
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
