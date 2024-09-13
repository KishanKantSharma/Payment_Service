package com.example.payment_service.service.interfaces;

import com.example.payment_service.pojo.Transaction;

public interface PaymentStatusService {
	
	public String processStatus(Transaction transaction);

}
