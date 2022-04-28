package com.ecom.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecom.cart.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@Query(value="select * from Carts where sessionid=? and cartAggregateId !=null", nativeQuery=true)
	Optional<Cart> isNewCart(String sessionid);
	
	@Query(value="select max(cartAggregateId) from carts", nativeQuery=true)
	Optional<Long> getNeCartAggID();

	@Modifying
	@Query(value="delete from carts where sessionid=? and productid =?", nativeQuery=true)
	void removeProductFromCart(String sessionid , Integer productId);

}
