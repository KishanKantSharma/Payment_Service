package com.example.payment_service.constant;

import lombok.Getter;

public enum ProviderEnum {
	STRIPE(1, "STRIPE");

	@Getter
    private final int id;
	
	@Getter
    private final String name;

    // Constructor for the enum
    ProviderEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to get enum by id
    public static ProviderEnum getById(int id) {
        for (ProviderEnum provider : values()) {
            if (provider.getId() == id) {
                return provider;
            }
        }
        throw new IllegalArgumentException("No ProviderEnum with id " + id);
    }

    // Method to get enum by name
    public static ProviderEnum getByName(String name) {
        for (ProviderEnum provider : values()) {
            if (provider.getName().equalsIgnoreCase(name)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("No ProviderEnum with name " + name);
    }
}
