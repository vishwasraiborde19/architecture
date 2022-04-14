package com.ecom.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDetails {

	private String emailAddress; 
	private String firstName; 
	private String lastName; 
	private String billingAddress; 
	private String deliveryAddress; 
	
}
