package com.ecom.order.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	public enum OrderStatus {
		NOT_STARTED, PLACED,CANCELLED, ERROR, COMPLETED
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private Long cardId;
	private Long deliveryId;
	private Long paymentId;
	
	private OrderStatus orderStatus;
	

}