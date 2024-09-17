package com.example.payment_service.utils;

import org.modelmapper.AbstractConverter;

import com.example.payment_service.constant.TransactionStatusEnum;

public class TxnStatusEnumConverter extends AbstractConverter<String, Integer> {

	@Override
	protected Integer convert(String source) {
		
		return TransactionStatusEnum.getByName(source).getId();
	
	}

}
