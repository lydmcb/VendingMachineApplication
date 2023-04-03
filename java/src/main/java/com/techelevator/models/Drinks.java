package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends Items implements Dispensable{

    public Drinks(String slotIdentifier, String name, BigDecimal price, int quantity, String type) {
        super(slotIdentifier, name, price, quantity, type);
    }

    @Override
    public String getMessage(){
       String drinksMessage = "Drinky, Drinky, Slurp Slurp!";
       return drinksMessage;
    }

}
