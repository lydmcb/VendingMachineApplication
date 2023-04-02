package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Items;

import java.math.BigDecimal;
import java.util.Map;

import static com.techelevator.application.VendingMachine.itemsList;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {

    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayItemList() {
        System.out.println("Slot Identifier    Name            Price        Quantity");
        for (Items item : itemsList) {
            System.out.println("    " + item.getSlotIdentifier() + "           " + item.getName() + "           "
                    + item.getPrice() + "            " + item.getQuantity());
        }
        System.out.println();
    }

    public void displayMuchy(){
        System.out.println("Munchy, Munchy, so Good! ");
    }
    public void displayCandy(){
        System.out.println("Sugar, Sugar, so Sweet! ");
    }
    public void displayDrinks(){
        System.out.println("Drinky, Drinky, Slurp Slurp! ");
    }
    public void displayGum(){
        System.out.println("Chewy, Chewy, Lots O Bubbles! ");
    }


}


