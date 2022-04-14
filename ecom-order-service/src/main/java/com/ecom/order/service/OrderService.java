package com.ecom.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.order.domain.Order;
import com.ecom.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;

	public Order placeOrder(Order order) {
		return repository.save(order);
	}

	public Order cancelOrder(Order order) {

		repository.delete(order);
		return order;
	}

}
