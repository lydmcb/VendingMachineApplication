package com.techelevator.application;

import com.techelevator.Logger;
import com.techelevator.models.*;
import com.techelevator.models.Munchy;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VendingMachine {

    private UserOutput userOutput;
    private UserInput userInput;
    public static List<Items> itemsList;
    private Logger logger;
    public static List<Items> shoppingCart;

    public VendingMachine() {
        userInput = new UserInput();
        userOutput = new UserOutput();
        itemsList = new ArrayList<>();
        logger = new Logger("audit.txt");
        shoppingCart = new ArrayList<>();


    }

    public void run() {

        readInFromFile();
        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {
                // display the vending machine slots
                userOutput.displayItemList();

            } else if (choice.equals("purchase")) {
                makePurchase();
                // make a purchase
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void makePurchase() {
        while (true) {
            String choice = userInput.getPurchase();
            if (choice.equals("feed")) {
                String moneyToSpend = userInput.getMoney();
                BigDecimal money = new BigDecimal(moneyToSpend);
            } else if (choice.equals("select")) {
                //select item
                userOutput.displayItemList();
                String selectedItem = userInput.selectItem();
                userOutput.displayMessage("You have chosen " + selectedItem);
            } else if (choice.equals("finish")) {
                    // finish
                    break;
                }
            }
        }

    public void readInFromFile() {
        File file = new File("catering1.csv");
        logger.write(LocalDateTime.now() + " - reading in the file");

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String items = fileScanner.nextLine();
                String[] itemProperties = items.split(",");

                String slotIdentifier = itemProperties[0];
                String name = itemProperties[1];
                BigDecimal price = new BigDecimal(itemProperties[2]);
                String type = itemProperties[3];

                if (type.equals("Munchy")) {
                    itemsList.add(new Munchy(slotIdentifier, name, price, 6,type));
                } else if (type.equals("Drinks")) {
                    itemsList.add(new Drinks(slotIdentifier, name, price, 6, type));
                } else if (type.equals("Gum")) {
                    itemsList.add(new Gum(slotIdentifier, name, price, 6, type));
                } else if (type.equals("Candy")) {
                    itemsList.add(new Candy(slotIdentifier, name, price, 6, type));
                }


            }


        } catch (FileNotFoundException e) {
            userOutput.displayMessage("File not found -- please try again");
            System.exit(0);
        }

    }
    
            public static void getItemsList (List < Items > itemsList) {
                VendingMachine.itemsList = itemsList;
            }
        }
