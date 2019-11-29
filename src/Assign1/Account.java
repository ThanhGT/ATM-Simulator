package Assign1;

/**
 * Title: Assignment 1
 * Objective: ATM Objective: Perform transactions similar to an ATM Machine 
 * Author: Thanh Tran 
 * Date: 01.16.19
 */

public class Account {

    private String customerName;
    private int iD;
    public double balance;
    public double annualInterestRate;

    /**
     * 2-arg constructor that creates a bank account with specified ID number and customer name
     * @param customerName name of customer
     * @param iD bank identification number
     */
    
    public Account(String customerName, int iD) {

        // assigns the formal arguments to the data fields
        this.customerName = customerName;
        this.iD = iD;

    }

    /**
     * a method that displays the account info 
     * @return accountInfo
     */
    
    @Override
    public String toString() {
        
        double earnedInterest = 100 * monthlyInterest();
        
        String accountInfo = ("\nCustomer: %s \nAccount Balance: %.2f \nMonthly interest earned: %.2f \n");
        
        //return accountInfo;
        return String.format (accountInfo, customerName, balance, earnedInterest);
    
    }   // end of toString method
    
    /**
     * a method that deposits a specified amount to the account
     * @param amount amount user deposits
     */
    
    public void deposit(double amount) {

        double newBalance;

        // throws an IllegalArgumentException if the amount is less than 0
        if (amount < 0) {

            throw new IllegalArgumentException("Amount needs to be a positive number \n");

        } else {
        
            // compute the new balance
            newBalance = balance + amount;
            System.out.printf("Your new balance is %.4f \n \n", newBalance);
        
        }

        this.balance = newBalance;
    
    }

    /**
     * a method that withdraw a specified amount to the account
     * @param amount the amount user withdraws
     */
    public void withdraw(double amount) {

        double newBalance;

        // throws an IllegalArgumentException if amount is less than 0
        if (amount < 0) {

            throw new IllegalArgumentException("Amount needs to be a positive number.\n");

        }

        // throws an IllegalArgumentException if amount is greater than balance
        if (amount > balance) {

            throw new IllegalArgumentException("Amount cannot be higher than your actual balance. Please revise \n");

        } else {
            
            //compute the new balance
            newBalance = balance - amount;
            
        }
        
        System.out.printf("Your new balance is %.4f \n \n", newBalance);

        this.balance = newBalance;
    }

    /**
     * a method that calculates the MONTHLY interest rate based on annual interest rate
     * @return earnedInterest
     */
    
    public double monthlyInterest() {

        double monthlyInterestRate;

        // compute the earnedInterest on customer balance
        monthlyInterestRate = balance * (annualInterestRate / 12 / 100);
        
        return monthlyInterestRate;

    }

    /**
     * an accessor to get customer name
     * @return customer name
     */
    public String getCustomerName() {
    
        return customerName;
    
    }

    /**
     * a mutator to set a customer's name
     * @param customerName name of customer
     */
    
    public void setCustomerName(String customerName) {
    
        this.customerName = customerName;
    
    }

    /**
     * an accessor to get customer bank ID
     * @return iD
     */
    
    public int getiD() {
        
        return iD;
        
    }

    /**
     * an accessor to get the balance of the bank account
     * @return balance of bank account
     */
    public double getBalance() {
        
        return balance;
        
    }

    /**
     * a mutator that sets the balance of a bank account
     * @param balance bank account balance
     */
    
    public void setBalance(double balance) {
        
        this.balance = balance;
        
    }

    /**
     * a accessor to get the annual interest rate
     * @return annual interest rate
     */
    
    public double getAnnualInterestRate() {
        
        return annualInterestRate;
        
    }

    /** 
     * a mutator to set the annual interest rate
     * @param annualInterestRate annual interest rate
     */
    
    public void setAnnualInterestRate(double annualInterestRate) {
        
        this.annualInterestRate = annualInterestRate;
        
    }

    /**
     * an accessor to print a message to an illegal argument exception that does occur
     * @return a message to the user about why the error occured
     */
    
//    public String getMessage() {
//
//        throw new IllegalArgumentException ex ("Amount needs to be a positive number");
//
//    }

}
