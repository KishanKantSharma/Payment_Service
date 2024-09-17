package com.example.payment_service.pojo;

import lombok.Data;

@Data
public class Transaction {
	
	private int id;
	private int userId;
	
	private String paymentMethod; 
	private String paymentType; 
	private String provider; 
	private String txnStatus; 
	
	private double amount; 
	private String currency; 
	private String merchantTransactionReference; 
	private String txnReference;
	private String providerCode;
	private String providerMessage; 
	
	int retryCount; 
	
	
}
