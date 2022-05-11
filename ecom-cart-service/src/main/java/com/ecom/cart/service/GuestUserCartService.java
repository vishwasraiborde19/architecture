package com.ecom.cart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.repository.CartRepository;
import com.ecom.cart.vo.CartVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GuestUserCartService {

	@Autowired
	private CartRepository cartRepository;

	public List<CartVO> getCustomerCart(String cartId) {
		return cartRepository.getCustomerCart(cartId).stream().map( cart -> {
			CartVO vo = new CartVO();
			BeanUtils.copyProperties(cart, vo);
			return vo;
		}).collect(Collectors.toList());
	}

	// for this example using server side session managed cart other alternative
	// could be with cookies
	public CartVO addorUpdateCartV2(CartVO cart) {

		List<Cart> customerCarts = cartRepository.getCustomerCart(cart.getSessionId());
		
		
		//Predicate ispresent = 
		//customerCarts.stream().filter(x -> isEm)

		// TODO is there way in java 11 to do this efficiently 
		// map move code to function 
		if (CollectionUtils.isEmpty(customerCarts)) {

			log.info("Creating new cart ");
			Cart newCartLine = new Cart();
			newCartLine.setSessionId(cart.getSessionId());
			newCartLine.setCartId(getNewCartAggID());
			newCartLine.setProductId(cart.getProductId());
			newCartLine.setQty(cart.getQty());
			newCartLine.setUserStatus(resolveUserStatus());
			newCartLine.setCartStatus(getCartStatus());
			newCartLine.setCartInceptionTime(getCartInceptionDate());

			cartRepository.save(newCartLine);

			BeanUtils.copyProperties(cart, newCartLine);
			return cart;

		} else {

			log.info("Updating existing cart ");
			Cart currentCartProduct = cartRepository.getProductFromCustomerCart(cart.getSessionId(),
			        cart.getProductId());

			if (!ObjectUtils.isEmpty(currentCartProduct)) {
				// update existing product in the cart
				currentCartProduct.setQty(cart.getQty());
				currentCartProduct.setUserStatus(resolveUserStatus());
				currentCartProduct.setCartStatus(getCartStatus());
				currentCartProduct.setCartInceptionTime(getCartInceptionDate());

				cartRepository.save(currentCartProduct);
				BeanUtils.copyProperties(currentCartProduct, cart);
				return cart;

			} else {
				// add new product to the cart
				Cart addNewProduct = new Cart();
				addNewProduct.setSessionId(cart.getSessionId());
				addNewProduct.setCartId(customerCarts.get(0).getCartId());
				addNewProduct.setProductId(cart.getProductId());
				addNewProduct.setQty(cart.getQty());
				addNewProduct.setUserStatus(resolveUserStatus());
				addNewProduct.setCartStatus(getCartStatus());
				addNewProduct.setCartInceptionTime(getCartInceptionDate());

				cartRepository.save(addNewProduct);
				BeanUtils.copyProperties(addNewProduct, cart);
				return cart;
			}

		}

	}
	
	public List<CartVO> checkout(CartVO cart) {
		
		List<Cart> currentCartProduct = cartRepository.getCustomerCart(cart.getSessionId());
		List<CartVO> cartResponse = new ArrayList<>();	
		
		currentCartProduct.stream().forEach(x -> {
			CartVO vo = new CartVO();
			x.setCartStatus("CHECKED_OUT");
			cartRepository.save(x);
			BeanUtils.copyProperties(x, vo);
			cartResponse.add(vo);
			});
		
		return cartResponse;
	}

	public Cart removeProduct(String sessionid, Integer productId) {
		log.info("Rem Products ---> " + sessionid + " : " + productId);
		cartRepository.removeProductFromCart(sessionid, productId);
		return new Cart();
	}

	private Integer getNewCartAggID() {
		// should this be a generation strategy , we want the code to remain lean with
		// cart operations
		return (cartRepository.getNeCartAggID() != null ? cartRepository.getNeCartAggID() + 1 : 1000);
	}
	
	
	// move to static constants
	private String resolveUserStatus() {

		return "GUEST_USER";
	}

	private String getCartStatus() {

		return "IN_CART";
	}

	private Date getCartInceptionDate() {

		return new Date();
	}

	

}
