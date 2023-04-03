package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Items implements Dispensable {

    public Gum(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity, type);
    }

    @Override
    public String getMessage(){
        String gumMessage= "Chewy, Chewy, Lots O Bubbles";
        return gumMessage;
    }

}
