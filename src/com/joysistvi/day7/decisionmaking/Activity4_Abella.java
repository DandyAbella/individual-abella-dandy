package com.joysistvi.day7.decisionmaking;

import java.util.Scanner;

public class Activity4_Abella {
    public static void main(String[] args) {
        Scanner userEntry = new Scanner(System.in);

        // Loop 6 times
        for (int i = 1; i <= 6; i++) {
            System.out.print("Enter your age: ");

            //check if input is valid
            if (!userEntry.hasNextInt()) {
                userEntry.next();
                i--;
                continue;
            }

            int age = userEntry.nextInt();

            // Validate age
            if (age < 0 || age > 100) {
                System.out.println("Invalid Age");
                continue; // skip this iteration
            }

            String category;

            // If-else-if ladder for categorization
            if (age >= 0 && age <= 2) {
                category = "Baby";
            } else if (age >= 3 && age <= 12) {
                category = "Child";
            } else if (age >= 13 && age <= 19) {
                category = "Teenager";
            } else if (age >= 20 && age <= 29) {
                category = "Young Adult";
            } else if (age >= 30 && age <= 59) {
                category = "Adult";
            } else {
                category = "Senior";
            }

            // Display result
            System.out.println("Age: " + age);
            System.out.println("Age category: " + category);
            System.out.println("----------------------");
        }

        userEntry.close();
    }
}
