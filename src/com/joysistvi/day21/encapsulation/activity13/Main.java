package com.joysistvi.day21.encapsulation.activity13;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("*    User Account Registration      *");
        System.out.println("*************************************");

        System.out.print("\nEnter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Middle Name: ");
        String middleName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Create object using constructor
        UserAccount account = new UserAccount(
                firstName,
                middleName,
                lastName,
                address,
                email,
                password
        );

        // Display account using toString()
        System.out.println("\n--- User Account Created ---");
        System.out.println(account);

        sc.close();
    }
}