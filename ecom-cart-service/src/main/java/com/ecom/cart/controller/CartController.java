package com.ecom.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.service.GuestUserCartService;
import com.ecom.cart.vo.CartVO;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/carts/guest/")
@Slf4j
public class CartController {

	@Autowired
	private GuestUserCartService cartService;

	
	@GetMapping("/cartsession")
	public String getTempCartID(HttpSession session) {
		return session.getId();
	}
	
	@GetMapping("/{cartId}")
	public List<CartVO> getCustomerCart(@PathVariable String cartId) {
		return cartService.getCustomerCart(cartId);
	}

	@PostMapping("/addProduct")
	public CartVO addProductToCart(HttpSession session, @RequestBody CartVO cart) {

		cart.setSessionId(session.getId());
		return cartService.addorUpdateCartV2(cart);
	}

	@PostMapping("/checkout")
	public List<CartVO> checkOutCart(HttpSession session, @RequestBody CartVO cart) {

		cart.setSessionId(session.getId());
		return cartService.checkout(cart);
	}

	@PostMapping("/removeProduct/{productId}")
	public Cart deleteProductFromCart(HttpSession session, @PathVariable Integer productId) {
		return cartService.removeProduct(session.getId(), productId);
	}

}
