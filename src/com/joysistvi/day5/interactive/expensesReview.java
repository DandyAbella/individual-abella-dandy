package com.joysistvi.day5.interactive;

import java.util.Scanner;

public class expensesReview {
    public static void main (String[] args){

        //
        String name = "Dandy Abella";
        String myPassword = "andith33";
        boolean correctPassword = false;
        boolean anotherTransaction = false;

        Scanner sc = new Scanner(System.in);

        System.out.println ("User Name: " + name);
        System.out.print ("Password: ");
        String password = sc.nextLine();

        if (password.equals (myPassword)) {
            correctPassword = true;
        } else {
            System.out.print("Password: ");
            password = sc.nextLine();
            if (password.equals(myPassword)) {
                correctPassword = true;
            }
        }

        if (correctPassword) {
            //loop for multiple transaction
            String choice;
            do {
                System.out.println("Access Granted");

                System.out.print("Monthly income: ");
                double income = sc.nextDouble();

                System.out.print("monthly rent: ");
                double rent = sc.nextDouble();

                System.out.println("Remaining Balance: " + (income - rent));

                //another transaction?
                System.out.print ("Do another transaction? (yes/no) :");
                choice = sc.next(); // reads one word
            } while (choice.equalsIgnoreCase("yes"));
                System.out.println ("Program ended... good bye!..." + name);

        } else {
            System.out.println ("Access Denied... program terminated...");
        }
        sc.close();
    }
}
