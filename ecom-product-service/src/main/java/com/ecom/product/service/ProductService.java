package com.ecom.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.product.domain.Product;
import com.ecom.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
//	public List<Product> getProductsCategories() {
//		return productRepository.getProductsCategories();
//	}
//
//
//	public List<Product> getProductsByCategory(String productCode) {
//		return productRepository.getProductsByCategory(productCode);
//	}


	public List<Product> productService() {
		return productRepository.findAll();
	}


	public Optional<Product> getProduct(String productCode) {
		return productRepository.findById(productCode);
	}
	
	public Optional<List<Product>> getProductsByProductLine(String productLine) {
		return productRepository.getProductsByProductLine(productLine);
	}


	public Product addProduct(Product product) {
		log.info(product.toString());
		return productRepository.save(product);
	}


	public Product deleteProduct(String productCode) {
		Product prd = new Product();
		prd.setProductCode(productCode);
	    productRepository.delete(prd);
	    return prd;
	}

}
