package com.ecom.cart.domain;

import java.util.List;

import com.ecom.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	private Long cartID;
	private List<Product> products;
	

}
