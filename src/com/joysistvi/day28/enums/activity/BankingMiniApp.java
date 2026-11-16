package com.joysistvi.day28.enums.activity;

import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected String pin;
    protected double balance;
    protected ArrayList<String> transactions = new ArrayList<>();

    public BankAccount(String accountNumber, String accountHolder,
                       String pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: PHP " + amount);
            System.out.println("Deposit Successful!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: PHP " + amount);
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (amount <= balance) {
            balance -= amount;
            receiver.balance += amount;

            transactions.add("Transferred PHP " + amount +
                    " to " + receiver.accountHolder);

            receiver.transactions.add(
                    "Received PHP " + amount +
                            " from " + accountHolder);

            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayBalance() {
        System.out.printf("Balance: PHP %.2f%n", balance);
    }

    public void displayTransactions() {
        System.out.println("\n===== TRANSACTION HISTORY =====");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            transactions.forEach(System.out::println);
        }
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder,
                          String pin, double balance) {
        super(accountNumber, accountHolder, pin, balance);
    }
}

public class BankingMiniApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SavingsAccount acc1 =
                new SavingsAccount("1001", "Dandi", "1234", 10000);

        SavingsAccount acc2 =
                new SavingsAccount("1002", "John", "5678", 5000);

        System.out.println("==== BANKING MINI APP ====");

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        BankAccount currentAccount = null;

        if (acc1.accountNumber.equals(accNo)
                && acc1.authenticate(pin)) {
            currentAccount = acc1;
        } else if (acc2.accountNumber.equals(accNo)
                && acc2.authenticate(pin)) {
            currentAccount = acc2;
        }

        if (currentAccount == null) {
            System.out.println("Invalid Account Number or PIN!");
            return;
        }

        System.out.println(
                "\nWelcome, " + currentAccount.accountHolder);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Amount: ");
                    double dep = sc.nextDouble();
                    currentAccount.deposit(dep);
                    break;

                case 2:
                    System.out.print("Amount: ");
                    double wit = sc.nextDouble();
                    currentAccount.withdraw(wit);
                    break;

                case 3:
                    currentAccount.displayBalance();
                    break;

                case 4:
                    System.out.print("Transfer Amount: ");
                    double amount = sc.nextDouble();

                    BankAccount receiver =
                            currentAccount == acc1 ? acc2 : acc1;

                    currentAccount.transfer(receiver, amount);
                    break;

                case 5:
                    currentAccount.displayTransactions();
                    break;

                case 6:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}