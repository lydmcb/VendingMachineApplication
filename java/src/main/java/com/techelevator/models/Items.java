package com.techelevator.models;

import java.math.BigDecimal;

public abstract class Items {

    private String name;
    private BigDecimal price;
    private String slotIdentifier;
    private int quantity;

    public Items(String name, BigDecimal price, String slotIdentifier, int quantity) {
        this.name = name;
        this.price = price;
        this.slotIdentifier = slotIdentifier;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
