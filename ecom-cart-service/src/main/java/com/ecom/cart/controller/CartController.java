package com.ecom.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/carts")
@Slf4j
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/")
	public List<Cart> getAllCarts() {
		return cartService.getAll();
	}
	
	@GetMapping("/{id}")
	public Cart getCart(@PathVariable Long id) {
		return cartService.getCart(id);
	}
	
	@GetMapping("/cartsession")
	public String getTempCartID(HttpSession session) {
		return session.getId();
	}

	@PostMapping("/")
	public Cart addProductToCart(HttpSession session, @RequestBody Cart cart) {
		
		log.info("SessionId :-> " + session.getId());
		log.info("Cart :-> " + cart.toString());
		
		//cart.setCustomerSessionId(session.getId());
		return cartService.addorUpdateCart(cart);
	}
	
	

}
