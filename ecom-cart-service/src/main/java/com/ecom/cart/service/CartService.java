package com.ecom.cart.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;

	public Cart getCart(Long cartID) {
		
		return cartRepository.getById(cartID);
	}

	public Cart addtoCart(Cart cart) {
		// getCardbyCartID
		
		return cartRepository.save(cart);
	}

	public Cart updateCart(Cart cart) {
		
		return addtoCart(cart);
	}
	
	public Long generateTempCatID() {
		
		return new Random().nextLong();
	}
	
	
	

}
