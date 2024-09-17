package com.example.payment_service.service.interfaces;

import com.example.payment_service.dto.TransactionDTO;

public abstract class PaymentStatusHandler {
	
	public abstract TransactionDTO processStatusHandler(TransactionDTO txnDTO);

}
