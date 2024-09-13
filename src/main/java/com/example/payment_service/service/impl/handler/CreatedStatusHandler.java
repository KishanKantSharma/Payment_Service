package com.example.payment_service.service.impl.handler;

import org.springframework.stereotype.Component;

import com.example.payment_service.pojo.Transaction;
import com.example.payment_service.service.interfaces.PaymentStatusHandler;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler {

	@Override
	public String processStatusHandler(Transaction transaction) {
		
		System.out.println("CreatedStatusHandler.processStatusHandler() ||" + "Transaction: " + transaction);
		
		return "Returning from CreatedStatusHandler";
	}

}
