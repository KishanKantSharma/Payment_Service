package com.example.payment_service.dao.interfaces;

import com.example.payment_service.dto.TransactionDTO;

public interface TransactionDao {
	
	public TransactionDTO createTransaction(TransactionDTO txnDTO);
	
}
