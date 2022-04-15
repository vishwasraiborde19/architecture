package com.ecom.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.order.domain.Orders;
import com.ecom.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	

	public Orders placeOrder(Orders order) {
		return repository.save(order);
	}

	public Orders cancelOrder(Orders order) {

		repository.delete(order);
		return order;
	}

}
