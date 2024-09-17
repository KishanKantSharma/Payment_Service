package com.example.payment_service.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.constant.EndPoints;
import com.example.payment_service.dto.TransactionDTO;
import com.example.payment_service.pojo.CreateTransactionRes;
import com.example.payment_service.pojo.Transaction;
import com.example.payment_service.service.interfaces.PaymentStatusService;

@RestController	
@RequestMapping(EndPoints.V1_PAYMENTS)
public class PaymentController {
	
	private ModelMapper modelMapper;
	private PaymentStatusService service;
	
	public PaymentController(ModelMapper modelMapper, PaymentStatusService service) {
		this.modelMapper = modelMapper;
		this.service = service; 
	}
	
	@PostMapping(value = {EndPoints.EMPTY_STRING, EndPoints.SLASH})
	public ResponseEntity<CreateTransactionRes> createPayment(@RequestBody Transaction transaction) {
		
		System.out.println("****Starting payment processing");
		
		TransactionDTO txnDTO = modelMapper.map(transaction, TransactionDTO.class);
		
		System.out.println("Transaction object after conversion: txnDTO"  + txnDTO);
		
		TransactionDTO valFromService = service.processStatus(txnDTO);
		
		System.out.println("PaymentController.createPayment() Transaction: " + txnDTO + "| " + valFromService);
		
		CreateTransactionRes response = new CreateTransactionRes();
		
		response.setId(valFromService.getId());
		response.setTxnStatus(valFromService.getTxnStatus());
		
		ResponseEntity<CreateTransactionRes> responseEntity = new ResponseEntity<CreateTransactionRes>(response, HttpStatus.CREATED);
		
		return responseEntity; 
	}
	
}
