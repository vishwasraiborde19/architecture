package com.ecom.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;

	public Cart getCart(Cart cart) {
		
		return cartRepository.getById(cart.getCartID());
	}

	public Cart addtoCart(Cart cart) {
		
		return cartRepository.save(cart);
	}

	public Cart updateCart(Cart cart) {
		
		return addtoCart(cart);
	}
	
	public Double generateTempCatID() {
		
		return Math.random();
	}
	
	
	

}
