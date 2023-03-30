package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends Items{

    public Drinks(String name, BigDecimal price, String slotIdentifier, int quantity) {
        super(name, price, slotIdentifier, quantity);
    }
}
