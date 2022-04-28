package com.ecom.cart.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	public List<Cart> getAll() {

		return cartRepository.findAll();

	}

	public Cart getCart(Long cartID) {

		return cartRepository.getById(cartID);
	}
	
	public Cart addorUpdateCart(Cart cart) {
		
		// up
		if(isNewCart(cart).isPresent()) {
			Cart currentCustomerCart = cartRepository.save(cart);	
			
			System.out.println("Exs Cart ---> " + currentCustomerCart.toString());

			return currentCustomerCart;
		}else {
			Cart cartd = new Cart();
			cartd.setProductId(cart.getProductId());
			cartd.setQty(cart.getQty());
			cartd.setSessionId(cart.getSessionId());
			cartd.setCartAggregateId(getNewCartAggID());
			System.out.println("New Cart ---> " + cartd.toString());
			Cart currentCustomerCart = cartRepository.save(cartd);

			return currentCustomerCart;
		}

	}

	@Transactional()
	public String removeProduct(String sessionid, Integer productId) {
		System.out.println("Rem Products ---> " + sessionid+ " : "+productId);
		
		cartRepository.removeProductFromCart(sessionid, productId);
		return "product removed from cart";
	}
	
	
	private Optional<Cart> isNewCart(Cart cart) {
		
		 Optional<Cart> response = cartRepository.isNewCart(cart.getSessionId());
		
		return (response.isPresent()? response : response.empty());
		
	}


	private Long getNewCartAggID() {
		
		if(cartRepository.getNeCartAggID().isPresent()) {
			return cartRepository.getNeCartAggID().get();
		}else {
		return 1000l;
		}
	}

}
