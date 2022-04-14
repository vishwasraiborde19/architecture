package com.ecom.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

	enum paymentType {
		DEBIT_CARD, CREDIT_CARD, BANK
	}

	enum paymentStatus {
		SUCCESS, FAILED, PENDING
	}

	private paymentType paymentType;
	private paymentStatus paymentStatus;
	private boolean storePaymentDetails;

}
