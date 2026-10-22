package com.joysistvi.day8.conditions;

import java.util.Scanner;

public class userInput {
    public static void main (String[] args) {
        Scanner scanner =  new Scanner(System.in);
                //"scanner" >> object class >>> lowercase >>

        // nextBoolean()
        // nextByte()
        // nextDouble()
        // nextFloat()
        // nextInt()
        // nextLine() >>> for String

        System.out.print("Enter day number (1-7): ");
        int day = scanner.nextInt();
        String dayName="";

        switch (day) {
            case 1:
                dayName = "monday";
                break;
            case 2:
                dayName = "tuesday";
                break;
            case 3:
                dayName = "wednesday";
                break;
            case 4:
                dayName = "thursday";
                break;
            case 5:
                dayName = "friday";
                break;
            case 6:
                dayName = "saturday";
                break;
            case 7:
                dayName = "sunday";
                break;
            default:
        }
        System.out.println ("Today is: " + dayName);
    }
}
