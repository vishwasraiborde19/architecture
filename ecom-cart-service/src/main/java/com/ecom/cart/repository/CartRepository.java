package com.ecom.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.cart.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
