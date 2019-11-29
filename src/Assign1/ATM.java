package Assign1;

import java.util.Scanner;

/**
 * Title: Assignment 1
 * Objective: ATM Objective: Perform transactions similar to an ATM Machine 
 * Author: Thanh Tran 
 * Date: 01.16.19
 */

public class ATM {

    public void menu(Account acct) {

        boolean again = true;
      
        while (again == true) {
            
            // menu 
            System.out.println("Main Menu");
            System.out.println("1. Account Info");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Please choose what you'd like to do: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            
            //switch statement
            switch (choice) {
                
                //display account info
                case 1:
                    System.out.println(acct.toString());
                    again = true;   // re-displays the menu
                    break;
                
                //client withdraws    
                case 2:
                    System.out.print("\nEnter the amount to withdraw: ");
                    double amountWithdraw = input.nextDouble();
                    acct.withdraw(amountWithdraw);
                    again = true;   // re-displays the menu
                    break;
                
                //client deposits    
                case 3:
                    System.out.print("\nEnter the amount to deposit: ");
                    Scanner input2 = new Scanner(System.in);
                    double amountDeposit = input2.nextDouble();
                    acct.deposit(amountDeposit);
                    again = true;   // re-displays the menu
                    break;
                
                // exits client's account, resetting program
                case 4:
                    again = false;  // 
                    break;
                default:
                    System.out.println("\nInvalid input. Please try again: \n");
                    break;


            } // end of switch statement
            
      } // end of a while loop
    
    } // end of method

    public static void main(String[] args) {

        // creates an object of class Account and sets the account name and ID 
            
        ATM myATM = new ATM();
        Account firstAccount = new Account("Thanh Tran", 101);
        Account secondAccount = new Account("Jed Dagondon", 102);

        // sets a value for balance of the two accounts
        firstAccount.balance = 50;
        secondAccount.balance = 1000;

        // sets the annual interst rate of the two accounts
        firstAccount.annualInterestRate = 0.05;
        secondAccount.annualInterestRate = 0.05;

        // ask the user to input an id
        System.out.print("Please enter an ID: ");
        Scanner input = new Scanner(System.in);
        int bankID = input.nextInt();
        boolean loopMe4Eva = true;

        // while loop that loops FOREVER
        while (loopMe4Eva) {
                
            try {
                    
                // if-condition, making sure the user inputs the right id        
                if (bankID == firstAccount.getiD()) {

                    myATM.menu(firstAccount);
                    System.out.print("Please enter an ID: ");
                    bankID = input.nextInt();

                } else if (bankID == secondAccount.getiD()) {

                    myATM.menu(secondAccount);
                    System.out.print("Please enter an ID: ");
                    bankID = input.nextInt();
                    
                } else if (bankID < 0) {

                    throw new IllegalArgumentException("ID needs to be a positive number.");
                    
                } else {

                    System.out.print("This ID does not exist. Please enter an existing ID: ");
                    bankID = input.nextInt();
                    
                }

            } catch (Exception ex) {

                System.out.println(ex.getMessage() + "Please enter an existing ID: ");                    
                bankID = input.nextInt();

            }   // end of catch
                
        }   // end of while loop
            
    } // end of main

} // end of class
