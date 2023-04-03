package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Items implements Dispensable {

    public Munchy(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity, type);
    }

    public String getMessage() {
        String munchyMessage = "Munchy, Munchy, so Good!";
        return munchyMessage;
    }
}