package com.ecom.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.order.domain.Order;
import com.ecom.order.service.OrderService;

@RestController("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/")
	public Order placeOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
	}
	
	@DeleteMapping
	public Order cancelOrder(@RequestBody Order order) {
		return orderService.cancelOrder(order);
	}

}
