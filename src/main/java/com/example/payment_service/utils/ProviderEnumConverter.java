package com.example.payment_service.utils;

import org.modelmapper.AbstractConverter;

import com.example.payment_service.constant.ProviderEnum;

public class ProviderEnumConverter extends AbstractConverter<String, Integer> {

	@Override
	protected Integer convert(String source) {
		
		return ProviderEnum.getByName(source).getId();
	}
	
}
