package com.ecom.order.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderSummary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderNumber;
	
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	
	private OrderLines orderlines;
	
//	private CustomerDetails customerDetails;
//	private CartDetails cartDetails;
//	private Delivery delivery;
//	private PaymentDetails paymentDetails;	
//	private OrderDetails dederDetails;

}
