package com.ecom.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecom.order.domain.Orders;
import com.ecom.order.service.OrderService;

@RestController("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/")
	public Orders placeOrder(@RequestBody Orders order) {
		
		// getProducts from cart
		// call cart service and get products and save in orderlines 
		restTemplate.getForEntity("", null);
		
		return orderService.placeOrder(order);
	}
	
	@DeleteMapping
	public Orders cancelOrder(@RequestBody Orders order) {
		return orderService.cancelOrder(order);
	}

}
