package com.example.payment_service.constant;

import lombok.Getter;

public enum TransactionStatusEnum {
	
	CREATED(1, "CREATED"),
    INITIATED(2, "INITIATED"),
    PENDING(3, "PENDING"),
    SUCCESS(4, "SUCCESS"),
    FAILURE(5, "FAILURE");
	
	@Getter
    private final int id;
	
	@Getter
    private final String name;

    TransactionStatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TransactionStatusEnum getById(int id) {
        for (TransactionStatusEnum status : values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        
        System.out.println("No TransactionStatusEnum Found by this ID: " + id);
        return null;
    }
}
