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
import java.util.Scanner;

public class VendingMachine {

    private UserOutput userOutput;
    private UserInput userInput;
    private List<Items> ItemsList;
    private Logger logger;


    public VendingMachine(){
        userInput = new UserInput();
        userOutput = new UserOutput();
        ItemsList = new ArrayList<>();
        logger = new Logger();

    }

    public void run() {
        readInFromFile(); // Will read in from method below

        while(true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                userOutput.displayMessage("Slot Identifier    Name    Price    Quantity");
                for(Items item : ItemsList){
                    userOutput.displayMessage(item.getSlotIdentifier() + "  " + item.getName() + "  " +
                            item.getPrice() + "  " + item.getQuantity());
                }
            }
            else if(choice.equals("purchase"))
            {
                makePurchase();
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    public void makePurchase(){
        while(true){
            String choice = userInput.getPurchase();
            if(choice.equals("feed")){
                //feed money
            } else if (choice.equals("select")){
                //select item
            } else if (choice.equals("finish")){
                // finish
                break;
            }
        }
    }


    public void readInFromFile() {
        File file = new File("catering.csv");
        try (Scanner fileScanner = new Scanner(file)){
            while (fileScanner.hasNextLine());
            String items = fileScanner.nextLine();
            String[] itemProperties = items.split(",");

            String slotIdentifier = itemProperties[0];
            String name = itemProperties[1];
            BigDecimal price = new BigDecimal(itemProperties[2]);
            String type = itemProperties[3];

            if (type.equals("Munchy")) {
                Munchy munchy = new Munchy(name, price, slotIdentifier, 6);
            } else if (type.equals("Drinks")){
                Drinks drinks = new Drinks(name,price,slotIdentifier, 6);
            } else if(type.equals("Gum")) {
                Gum gum = new Gum(name, price, slotIdentifier, 6);
            } else if (type.equals("Candy")){
                Candy candy = new Candy(name, price, slotIdentifier, 6);
            }



        } catch (FileNotFoundException e) {
            userOutput.displayMessage("File not found -- please try again");
            System.exit(0);
        }
        //       logger.write(LocalDateTime.now() + " - reading in the file");
    }
    
}
