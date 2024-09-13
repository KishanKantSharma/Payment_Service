package com.example.payment_service.service.interfaces;

import com.example.payment_service.pojo.Transaction;

public abstract class PaymentStatusHandler {
	
	public abstract String processStatusHandler(Transaction transaction);

}
