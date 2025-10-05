package samplearrays;

public class BankAccount {

    String name;
    private double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    final private double[] transactions = new double[1000];
    private int transactionCount = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    private void addTransaction(double amount){
        if (transactionCount < transactions.length) {
            transactions[transactionCount] = amount;
            transactionCount++;
        } else {
            System.out.println("Transaction history is full!"); // <---
        }
    }

    public void deposit(double amount){
        if (amount > 0) {
            this.currentBalance += amount;
            // add the amount to transactions:
            addTransaction(amount);
            System.out.println("[ (+) Deposit : --> User \" "+this.name+" \", deposited " + amount + "|||| the new balance : " +  this.currentBalance + "]");
        }
        else {
            System.out.println("Unable to deposit amount!");
        }
    }

    public void withdraw(double amount){
        if(amount < this.currentBalance){
            this.currentBalance -= amount;
            // add transaction as negative
            addTransaction(-amount);
            // since it's not mentioned to be added i left it as a comment
            // System.out.println("[ (-) Withdrawal : --> User \" "+this.name+" \", withdrew " + amount + "|||| the new balance : " +  this.currentBalance + "]")
        }
        else{
            System.out.println("Unable to withdraw amount! ( You don't have enough money )");
        }
    }

    public void displayTransactions(){
        System.out.println("-----------------------");
        System.out.println("[ Transaction History ]");
        for(int i = 0; i < transactionCount; i++){
            if(transactions[i] > 0) System.out.println("[ (+) Deposit : --> " + transactions[i] + "]");
            else System.out.println("[ (+) Withdraw : --> " + -transactions[i] + "]");
        }
        System.out.println("---------------------");
    }

    public void displayBalance(){
        System.out.println("-----------------------");
        System.out.println("[ Account Balance : " + this.currentBalance + "]");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
