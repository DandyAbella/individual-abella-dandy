package com.joysistvi.day6.conditions;

import java.util.Scanner;

public class Activity3_Abella {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        //task 2: event entry check
        int age;
        boolean hasValidId;
        System.out.println("");
        System.out.println("Task 2: event entry check");
        System.out.print ("Enter age: ");
        age = sc.nextInt();
        System.out.print ("Has a valid id? (yes/no): ");
        String idInput = sc.next();
        hasValidId = idInput.equalsIgnoreCase( "yes");
        String idStatus = hasValidId ? "YES" : "NO"; //convert boolean to YES/NO string
        if (age >=18 && hasValidId) {
            System.out.println ("Allowed to enter the event: " + idStatus);
            } else {
        System.out.println ("Allowed to enter the event: " + idStatus);
        }

        //task 3: class status check:
        boolean isWeekend = true;
        boolean isHoliday = false;
        String isWeekendStatus = isWeekend ? "YES" : "NO"; //convert boolean to YES/NO string
        String isHolidayStatus = isHoliday ? "YES" : "NO";
        if (isWeekend || isHoliday) {
            System.out.println("");
            System.out.println ("Task 3: class Status check");
            System.out.println ("Are there NO classes today? Yes! No classes");
        } else {
            System.out.println ("Are there NO classes today? No! There is class");
        }

        //task 4: pass or fail check
        int score;
        System.out.println("");
        System.out.println("Task 4: pass or fail check");
        System.out.print ("Enter score: ");
        score = sc.nextInt();
        String result = (score >= 75) ? "Passed" : "Failed";
        System.out.println ("Score: " + score);
        System.out.println ("Result: " + result );

        //task 5: larger number check
        int num1;
        int num2;
        System.out.println("");
        System.out.println("Task 5: larger number check");
        System.out.print("enter Number1: ");
        num1 = sc.nextInt();
        System.out.print("enter Number2: ");
        num2 = sc.nextInt();
        int largerNumber = (num1 > num2) ? num1 : num2;
        System.out.println("Number 1: " + num1 + ", Number 2: " + num2);
        System.out.println("The larger number is: " + largerNumber);


        sc.close();
    }
}
