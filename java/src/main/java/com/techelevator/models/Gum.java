package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Items {

    public Gum(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity, type);
    }
}
