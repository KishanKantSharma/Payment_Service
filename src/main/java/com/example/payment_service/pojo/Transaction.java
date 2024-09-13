package com.example.payment_service.pojo;

import lombok.Data;

@Data
public class Transaction {
	
	private int id;
	private int userId;
	private int paymentMethodId; 
	private int providerId; 
	private int paymentTypeId; 
	private int txnStatusId; 
	private double amount; 
	private String currency; 
	private String merchantTransactionReference; 
	private String txnReference; 
	
}
