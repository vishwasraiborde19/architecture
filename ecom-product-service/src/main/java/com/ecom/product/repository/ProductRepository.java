package com.ecom.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.product.domain.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{
	
	@Query(value = "select * from product where catID =?", nativeQuery=true)
	public List<Product> getProductsByCategory(Long catID);
	
	
	// where the domain field have camelcasing categoryName the columns will required to be replace as category_name
	@Query(value = "select catID,category_name from product", nativeQuery=true)
	public List<Product> getProductsCategories ();
	

}
