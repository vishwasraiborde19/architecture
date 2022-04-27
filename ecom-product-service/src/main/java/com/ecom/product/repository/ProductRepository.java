package com.ecom.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.product.domain.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, String>{
	
	@Query(value = "select * from products where productLine=?", nativeQuery=true)
	public Optional<List<Product>> getProductsByProductLine(String productLine);
//	
//	
//	// where the domain field have camelcasing categoryName the columns will required to be replace as category_name
//	@Query(value = "select catID,categoryname from product", nativeQuery=true)
//	public List<Product> getProductsCategories ();
	

}
