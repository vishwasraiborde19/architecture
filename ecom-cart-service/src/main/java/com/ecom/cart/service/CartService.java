package com.ecom.cart.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		List<Cart> cartsitems = cartRepository.getCurrentCartforSession(cart.getCustomerSessionId());
		
		if (isNewCart(cartsitems)) {
			
			// this is bad very bad but will roll with hack to save time
			cart.setCartId(getNeWCartID());
			cartRepository.save(cart);

		} else {
			Long cartId= cartsitems.stream().findFirst().get().getCartId();
			cart.setCartId(cartId);
			cartRepository.save(cart);
		}
		return cart;
	}

	private boolean isNewCart(List cartitems) {

		if (cartitems.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	private Long getNeWCartID() {
		Optional<Long> cartId = cartRepository.getNeWCartID();
		if(cartId.isPresent()) {
			return cartId.get() + 100;
		}else {
			return 100l;
		}
	}

}
