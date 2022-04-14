package com.ecom.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.service.CartService;

@RestController("/carts")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/")
	public Cart getCart(Long cartID) {
		return cartService.getCart(cartID);
	}
	
	@GetMapping("/")
	public Long getTEmpCartID() {
		return cartService.generateTempCatID();
	}

	@PostMapping("/")
	public Cart addProductToCart(Cart cart) {
		return cartService.addtoCart(cart);
	}
	
	

}
