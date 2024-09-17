package com.example.payment_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.payment_service.constant.TransactionStatusEnum;
import com.example.payment_service.dto.TransactionDTO;
import com.example.payment_service.factory.PaymentStatusFactory;
import com.example.payment_service.service.interfaces.PaymentStatusHandler;
import com.example.payment_service.service.interfaces.PaymentStatusService;


@Component
public class PaymentStatusServiceImpl implements PaymentStatusService {

	@Autowired
	PaymentStatusFactory statusFactory; 
	
	@Override
	public TransactionDTO processStatus(TransactionDTO txnDTO) {
		
		System.out.println("PaymentStatusServiceImpl.processStatus() | " + "transactionDTO : " + txnDTO);
		
		System.out.println("******* TransactionDTO Status Id: " + txnDTO.getTxnStatus());
		
		TransactionStatusEnum statusEnum = TransactionStatusEnum.getByName(txnDTO.getTxnStatus());
		
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler(statusEnum);
		
		TransactionDTO processStatusResponse = statusHandler.processStatusHandler(txnDTO);
		
		return processStatusResponse;
	}

}
 	