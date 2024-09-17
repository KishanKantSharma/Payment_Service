package com.example.payment_service.constant;

import lombok.Getter;

public enum PaymentTypeEnum {
	SALE(1, "SALE");
	
	@Getter
    private final int id;
	
	@Getter
    private final String name;

    // Constructor for the enum
    PaymentTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to get enum by id
    public static PaymentTypeEnum getById(int id) {
        for (PaymentTypeEnum paymentType : values()) {
            if (paymentType.getId() == id) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException("No PaymentTypeEnum with id " + id);
    }

    // Method to get enum by name
    public static PaymentTypeEnum getByName(String name) {
        for (PaymentTypeEnum paymentType : values()) {
            if (paymentType.getName().equalsIgnoreCase(name)) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException("No PaymentTypeEnum with name " + name);
    }
}
