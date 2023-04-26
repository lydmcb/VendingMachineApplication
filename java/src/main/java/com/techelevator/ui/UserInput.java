package com.techelevator.ui;

import com.techelevator.models.Items;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.techelevator.application.VendingMachine.itemsList;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    BigDecimal cashAmount = new BigDecimal(0.0);


    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("d")) {
            return "display";
        } else if (option.equals("p")) {
            return "purchase";
        } else if (option.equals("e")) {
            return "exit";
        } else {
            return "";
        }

    }

    public String getPurchase() {

        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();

        System.out.print("Current Money Provided: $" + cashAmount);
        System.out.println();

        System.out.print("Please select option: ");
        String newOption = scanner.nextLine();
        String purchaseOption = newOption.trim().toLowerCase();

        if (purchaseOption.equals("m")) {
            return "feed";
        } else if (purchaseOption.equals("s")) {
            return "select";
        } else {
            return "finish";
        }
    }



    public String getMoney() {

        while (true) {
            try {
            System.out.print("Please enter cash ($1, $5, $10, $20 accepted): ");
            String enteredMoney = scanner.nextLine();
            BigDecimal eM = new BigDecimal(enteredMoney);
            cashAmount = cashAmount.add(eM);
        } catch (NumberFormatException e) {
                System.out.println("Invalid Entry");
            }
            System.out.print("Would you like to add anything else? (Y/N): ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("y")) {
                continue;
            } else {
                return String.valueOf(cashAmount);
            }
        }
    }


    public String selectItem() {
       String message = "";
        System.out.print("Please select an item from above: ");
        String selection = scanner.nextLine().toUpperCase();

        for (Items items : itemsList) {
            while (selection.equals(items.getSlotIdentifier())) {
                if (items.getQuantity() <= 0) {
                    selection = "Item no longer available";
                } else if (items.getPrice().compareTo(cashAmount) == 1) {
                    selection = "Not enough funds";
                } else {
                    selection = items.getName();
                    cashAmount = cashAmount.subtract(items.getPrice());
                    message = items.getMessage();
                    int quantity = items.getQuantity();
                    quantity--;
                    items.setQuantity(quantity);

                }
            }
        }
        return selection + " | " + message;
    }

    public String returnChange() {
        BigDecimal startingAmount = cashAmount;
        int cents = cashAmount.multiply(new BigDecimal("100")).intValue();
        int[] change = new int[]{100, 25, 10, 5};
        String[] currency = new String[]{"Dollars", "Quarters", "Dimes", "Nickles"};
        for (int i = 0; i < change.length; i++) {
               int counter =  (cents / change[i]);
                cents =  (cents % change[i]);

                System.out.println("Your Change is: " + counter + " " + currency[i]);
                cashAmount = BigDecimal.valueOf(0);
            }
            return startingAmount + "  " + cashAmount;
        }

    }
