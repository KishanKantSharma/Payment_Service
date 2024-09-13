package com.example.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.constant.EndPoints;
import com.example.payment_service.pojo.Transaction;
import com.example.payment_service.service.interfaces.PaymentStatusService;

@RestController
@RequestMapping(EndPoints.V1_PAYMENTS)
public class PaymentController {
	
	@Autowired
	private PaymentStatusService service;
	
	@PostMapping(value = {EndPoints.EMPTY_STRING, EndPoints.SLASH})
	public String createPayment(@RequestBody Transaction transaction) {
		
		System.out.println("****Starting payment processing");
		
		String valFromService = service.processStatus(transaction);
		
		System.out.println("PaymentController.createPayment() Transaction: " + transaction + "| " + valFromService);
		
		return "123" + valFromService; 
	}
	
}
