package com.example.payment_service.constant;

import lombok.Getter;

public enum PaymentMethodEnum {
	APM(1, "APM");

	@Getter
    private final int id;
    
	@Getter
	private final String name;

    // Constructor for the enum
    PaymentMethodEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to get enum by id
    public static PaymentMethodEnum getById(int id) {
        for (PaymentMethodEnum paymentType : values()) {
            if (paymentType.getId() == id) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException("No PaymentTypeEnum with id " + id);
    }

    // Method to get enum by name
    public static PaymentMethodEnum getByName(String name) {
        for (PaymentMethodEnum paymentType : values()) {
            if (paymentType.getName().equalsIgnoreCase(name)) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException("No PaymentTypeEnum with name " + name);
    }
}
