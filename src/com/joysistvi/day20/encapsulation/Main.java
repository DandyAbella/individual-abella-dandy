package com.joysistvi.day20.encapsulation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserAccount user = new UserAccount();

        System.out.println("*************************************");
        System.out.println("*    User Account Registration      *");
        System.out.println("*************************************");

        System.out.print("\nEnter First Name: ");
        user.setFirstName(sc.nextLine());

        System.out.print("Enter Middle Name: ");
        user.setMiddleName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        user.setLastName(sc.nextLine());

        System.out.print("Enter Address: ");
        user.setAddress(sc.nextLine());

        System.out.print("Enter Email: ");
        user.setEmail(sc.nextLine());

        System.out.print("Enter Password: ");
        user.setPassword(sc.nextLine());

        System.out.println("\n--- User Account Created ---");
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Email: " + user.getEmail());

        sc.close();
    }
}