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

    public BigDecimal cashAmount = new BigDecimal(0.0);
    String enteredMoney = "0.00";

    public String getMoney() {
        while (true) {
            System.out.print("Please enter cash ($1, $5, $10, $20 accepted): ");
            enteredMoney = scanner.nextLine();
            BigDecimal eM = new BigDecimal(enteredMoney);
            cashAmount = cashAmount.add(eM);
            System.out.print("Would you like to add anything else? (Y/N): ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("y")) {
                continue;
            } else {

                return String.valueOf(cashAmount);
            }
        }
    }

    String selection;
    String message;
    int quantity;

    public String selectItem() {
        System.out.print("Please select an item from above: ");
        selection = scanner.nextLine().toUpperCase();

        for (Items items : itemsList) {
            while (selection.equals(items.getSlotIdentifier())) {
                if (items.getQuantity() <= 0) {
                    selection = "Item no longer available";
                } else if (items.getPrice().compareTo(cashAmount) == 1) {
                    selection = "Not enough funds";
                } else {
<<<<<<< HEAD
                    selection = (itemsList.get(i).getName());
=======
                    selection = items.getName();
                    cashAmount = cashAmount.subtract(items.getPrice());
                    message = items.getMessage();
                    quantity = items.getQuantity();
                    quantity--;
                    items.setQuantity(quantity);
>>>>>>> lydia
                }
            }
        }
        return message + "!  You have selected " + selection + ", your remaining money is " + cashAmount;
    }

    public void returnChange() {

        double dblValue = cashAmount.doubleValue();
        double[] change = new double[]{(1.00), (0.25), (0.10), (0.05)};
        String[] currency = new String[]{"Dollars", "Quarters", "Dimes", "Nickles"};
        for (int i = 0; i < change.length; i++) {
            if (dblValue > 0) {
                int counter;

                counter = (int) ((int) dblValue / change[i]);
                dblValue -= (double) (change[i] * counter);


                System.out.println("Your Change is: " + counter + " " + currency[i]);
            }
        }

    }
}