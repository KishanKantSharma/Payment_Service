package com.example.payment_service.service.impl.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.payment_service.dao.impl.TransactionDaoImpl;
import com.example.payment_service.dto.TransactionDTO;
import com.example.payment_service.service.interfaces.PaymentStatusHandler;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler {

	@Autowired
	TransactionDaoImpl transactionDaoImpl;
	
	@Override
	public TransactionDTO processStatusHandler(TransactionDTO txnDTO) {
		
		// TransactionDTO with the transaction id
		TransactionDTO responseFromDaoImpl = transactionDaoImpl.createTransaction(txnDTO);
		
		System.out.println("Response from TransactionDaoImpl : " + responseFromDaoImpl);
		
		return responseFromDaoImpl;
	}

}
