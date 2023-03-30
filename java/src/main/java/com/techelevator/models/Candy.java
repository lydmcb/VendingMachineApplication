package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Items {

    public Candy(String name, BigDecimal price, String slotIdentifier, int quantity) {
        super(name, price, slotIdentifier, quantity);
    }
}
