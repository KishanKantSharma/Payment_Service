package com.example.payment_service.utils;

import org.modelmapper.AbstractConverter;

import com.example.payment_service.constant.PaymentMethodEnum;

public class PaymentMethodEnumConverter extends AbstractConverter<String, Integer> {
	
	@Override
	protected Integer convert(String source) {
				
		return PaymentMethodEnum.getByName(source).getId();
	}
}
