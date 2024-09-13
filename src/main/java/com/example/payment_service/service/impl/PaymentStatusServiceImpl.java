package com.example.payment_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.payment_service.constant.TransactionStatusEnum;
import com.example.payment_service.factory.PaymentStatusFactory;
import com.example.payment_service.pojo.Transaction;
import com.example.payment_service.service.interfaces.PaymentStatusHandler;
import com.example.payment_service.service.interfaces.PaymentStatusService;


@Component
public class PaymentStatusServiceImpl implements PaymentStatusService {

	@Autowired
	PaymentStatusFactory statusFactory; 
	
	@Override
	public String processStatus(Transaction transaction) {
		
		System.out.println("PaymentStatusServiceImpl.processStatus() | " + "transaction: " + transaction);
		
		System.out.println("******* Transaction Status Id: " + transaction.getTxnStatusId());
		
		TransactionStatusEnum statusEnum = TransactionStatusEnum.getById(transaction.getTxnStatusId());
		
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler(statusEnum);
		
		String processStatusResponse = statusHandler.processStatusHandler(transaction);
		
		return "Returning from service " + processStatusResponse;
	}

}
 	