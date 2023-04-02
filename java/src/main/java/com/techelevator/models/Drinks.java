package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends Items{

    public Drinks(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity, type);
    }
}
