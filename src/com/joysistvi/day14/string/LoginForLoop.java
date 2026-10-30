package com.joysistvi.day14.string;

import java.util.Scanner;

public class LoginForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "1234";
        final int maxAttempt = 3;

        for (int attempt = 1; attempt <= maxAttempt; attempt++) {
            System.out.println("Login Attempt " + attempt);

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login Successful!");
                break;
            } else {
                System.out.println("Invalid Username or Password.");

                if (attempt == maxAttempt) {
                    System.out.println("Maximum attempts reached. Access Denied.");
                }
            }
        }

        sc.close();
    }
}