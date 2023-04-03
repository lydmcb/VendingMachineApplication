package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Items implements Dispensable {

    public Candy(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity,type);
    }

    @Override
    public String getMessage(){
        String candyMessage = "Sugar, Sugar, so Sweet!";
        return candyMessage;
    }
}
