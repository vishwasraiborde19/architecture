package com.ecom.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.service.CartService;

@RestController("/carts")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	public Cart getCart(Cart cart) {
		return cartService.getCart(cart);
	}

	public Cart addtoCart(Cart cart) {
		return cartService.addtoCart(cart);
	}
	
	public Cart updateCart(Cart cart) {
		return cartService.updateCart(cart);
	}

}
