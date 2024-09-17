package com.example.payment_service.utils;

import org.modelmapper.AbstractConverter;

import com.example.payment_service.constant.PaymentTypeEnum;

public class PaymentTypeEnumConverter extends AbstractConverter<String, Integer> {
	
	@Override
	protected Integer convert(String source) {
		
		return PaymentTypeEnum.getByName(source).getId();
	}
}
