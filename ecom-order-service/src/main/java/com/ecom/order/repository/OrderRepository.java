package com.ecom.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
