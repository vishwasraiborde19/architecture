package com.ecom.cart.domain;

import com.ecom.product.domain.ProductLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	private Long cartID;
	private ProductLine productline;
	

}

