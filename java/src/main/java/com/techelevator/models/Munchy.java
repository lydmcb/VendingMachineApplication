package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Items {

    public Munchy(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity, type);
    }
}
