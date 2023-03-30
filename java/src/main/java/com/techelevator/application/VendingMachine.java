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
        readInFromFile();


    }


    {
        while(true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }

    private void readInFromFile() {
        File file = new File("");
        logger.write(LocalDateTime.now() + " - reading in the file");
    }
    
}
