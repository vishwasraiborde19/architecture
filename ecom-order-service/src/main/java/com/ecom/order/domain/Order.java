package com.ecom.order.domain;

import java.util.List;

import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	
	private Long orderID;
	private List<Product> productlines;
	private DeliveryDetails deliveryDetails;
	private PaymentDetails paymentDetails;
	
	

}
