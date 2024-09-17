package com.example.payment_service.dao.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.example.payment_service.dao.interfaces.TransactionDao;
import com.example.payment_service.dto.TransactionDTO;
import com.example.payment_service.entity.TransactionEntity;

@Component
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public TransactionDTO createTransaction(TransactionDTO txnDTO) {
		
		TransactionEntity txnEntity = modelMapper.map(txnDTO, TransactionEntity.class);
		
		System.out.println("Converted DTO To Entity:" + txnEntity);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO `Transaction` (userId, paymentMethodId, paymentTypeId, providerId, txnStatusId, amount, currency, merchantTransactionReference, txnReference, providerCode, providerMessage, retryCount) " +
		        "VALUES (:userId, :paymentMethodId, :paymentTypeId, :providerId, :txnStatusId, :amount, :currency, :merchantTransactionReference, :txnReference, :providerCode, :providerMessage, :retryCount)";
		
		int insertRowCount = namedParameterJdbcTemplate.update(
				sql, 
				new BeanPropertySqlParameterSource(txnEntity), 
				keyHolder, 
				new String[] {"id"}
			);
		
		int transactionId = keyHolder.getKey().intValue();
		
		txnDTO.setId(transactionId);
		 
		System.out.println("Inserted value in DB Count of insert Rows: "  + insertRowCount + "| Transaction ID: " + transactionId);
		
		return txnDTO; 
	}
	
}
