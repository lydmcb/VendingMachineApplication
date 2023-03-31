package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Items {

    public Candy(String slotIdentifier, String name, BigDecimal price, int quantity) {
        super(slotIdentifier, name, price, quantity);
    }
}
