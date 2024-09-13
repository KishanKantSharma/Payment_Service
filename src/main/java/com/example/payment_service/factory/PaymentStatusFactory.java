package com.example.payment_service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.payment_service.constant.TransactionStatusEnum;
import com.example.payment_service.service.impl.handler.CreatedStatusHandler;
import com.example.payment_service.service.interfaces.PaymentStatusHandler;

@Component
public class PaymentStatusFactory {
	
	@Autowired
	ApplicationContext ctx;
	
	public PaymentStatusHandler getStatusHandler(TransactionStatusEnum status) {
		
		switch(status) {
		
		case CREATED: 
			CreatedStatusHandler handler = ctx.getBean(CreatedStatusHandler.class);
			return handler;
		
		case INITIATED: 
			
		default:
			System.out.println("NO Handler found for this status" + status.getName());
			return null; 	
		}
		
	}
	
}
