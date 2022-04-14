package com.ecom.cart.domain;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	private Long cartID;
	private List<Product> products;
	

}
