package com.ecom.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecom.cart.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@Query(value="select * from Cart where customer_session_id=?", nativeQuery=true)
	List<Cart> getCurrentCartforSession(String customerSessionId);
	
	@Query(value="select max(cart_id) from cart", nativeQuery=true)
	Optional<Long> getNeWCartID();

}
