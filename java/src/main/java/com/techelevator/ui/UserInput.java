package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public  String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("d"))
        {
            return "display";
        }
        else if (option.equals("p"))
        {
            return "purchase";
        }
        else if (option.equals("e"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public String getPurchase(){

        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
       String cashAmount = "0.00";
        BigDecimal enteredCash = new BigDecimal(cashAmount);
        System.out.print("Current Money Provided: $" + String.valueOf(enteredCash));
        System.out.println();

        System.out.print("Please select option: ");
       String newOption = scanner.nextLine();
       String purchaseOption = newOption.trim().toLowerCase();

       if (purchaseOption.equals("m")){
           return "feed";
        } else if (purchaseOption.equals("s")) {
           return "select";
       } else {
           return "finish";
       }

       public String feedMoney();


 /*       if (purchaseOption.equals("m")){
            while(true){
                System.out.print("Please enter cash ($1, $5, $10, $20 accepted): ");
                cashAmount = scanner.nextLine();
                System.out.print("Would you like to add anything else? (Y/N): ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("n")){
                    return cashAmount;
                    break;
                }

            }
*/
    }


    
}
