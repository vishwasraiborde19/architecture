package com.ecom.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payment.domain.CardPaymentDetails;
import com.ecom.payment.service.PaymentService;

@RestController()
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	
	@PostMapping("/cardpayments")
	public CardPaymentDetails makeCardPayment(@RequestBody CardPaymentDetails cardPaymentDetails) {
		return paymentService.makecardpayment(cardPaymentDetails);
	}

}
