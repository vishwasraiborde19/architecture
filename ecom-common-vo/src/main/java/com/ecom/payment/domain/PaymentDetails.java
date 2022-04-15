package com.ecom.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

	 enum PaymentType {
		DEBIT_CARD, CREDIT_CARD, BANK
	}

	 enum PaymentStatus {
		SUCCESS, FAILED, PENDING
	}

	private PaymentType paymentType;
	private PaymentStatus paymentStatus;
	private boolean storePaymentDetails;

}
