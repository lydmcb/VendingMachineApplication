package com.techelevator.application;

import com.techelevator.Logger;
import com.techelevator.models.Items;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    private void readInFromFile() {
        File file = new File("catering.csv");
 //       logger.write(LocalDateTime.now() + " - reading in the file");
    }
    
}
