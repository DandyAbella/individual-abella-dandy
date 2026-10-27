package com.joysistvi.day12.arrray;
import java.util.Scanner;
public class Activity8_Abella {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declare array of 5 integers
        int[] numbers = new int[5];

        int sum = 0;
        int highest;
        int lowest;

        // Input 5 numbers
        System.out.println("Enter 5 numbers :");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }

        // Initialize highest and lowest
        highest = numbers[0];
        lowest = numbers[0];

        // Find highest and lowest
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }

            if (numbers[i] < lowest) {
                lowest = numbers[i];
            }
        }

        // Compute average
        double average = (double) sum / numbers.length;

        // Display numbers entered
        System.out.println("\nNumbers entered:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // Display results
        System.out.println("\n\nSum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Highest Number = " + highest);
        System.out.println("Lowest Number = " + lowest);

        input.close();
    }

}
