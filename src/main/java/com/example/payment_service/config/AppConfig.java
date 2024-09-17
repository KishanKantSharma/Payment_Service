package com.example.payment_service.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.payment_service.dto.TransactionDTO;
import com.example.payment_service.entity.TransactionEntity;
import com.example.payment_service.utils.PaymentMethodEnumConverter;
import com.example.payment_service.utils.PaymentTypeEnumConverter;
import com.example.payment_service.utils.ProviderEnumConverter;
import com.example.payment_service.utils.TxnStatusEnumConverter;

@Configuration
public class AppConfig {
	
	@Bean
	ModelMapper getModelMapper() {
		
		ModelMapper modelMapper = new ModelMapper(); 
		
		// Converters object creation
		Converter<String, Integer> PaymentMethodEnumConverter = new PaymentMethodEnumConverter();
		Converter<String, Integer> TxnStatusEnumConverter = new TxnStatusEnumConverter();
		Converter<String, Integer> PaymentTypeEnumConverter = new PaymentTypeEnumConverter();
		Converter<String, Integer> ProviderEnumConverter = new ProviderEnumConverter();
		
		modelMapper.addMappings(new PropertyMap<TransactionDTO, TransactionEntity>() {

			@Override
			protected void configure() {
				
				// adding converters to use
				using(PaymentMethodEnumConverter).map(source.getPaymentMethod(), destination.getPaymentMethodId());
				using(TxnStatusEnumConverter).map(source.getTxnStatus() , destination.getTxnStatusId());
				using(PaymentTypeEnumConverter).map(source.getPaymentType(), destination.getPaymentTypeId());
				using(ProviderEnumConverter).map(source.getProvider(), destination.getProviderId());
				
			}
			
		});
		
		return modelMapper; 
		
	}
	
	
	
}
