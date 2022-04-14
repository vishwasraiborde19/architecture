package com.ecom.order.domain;

import java.util.List;

import com.ecom.delivery.domain.DeliveryDetails;
import com.ecom.payment.domain.PaymentDetails;
import com.ecom.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	
	private Long orderID;
	private List<Product> productlines;
	private DeliveryDetails deliveryDetails;
	private PaymentDetails paymentDetails;
	
	

}
