package com.joysistvi.day9.loop;

import java.util.Scanner;

public class activity6_Abella {
    public static void main(String[] args) {
        Scanner multiplication = new Scanner(System.in);

        //multiplication table using Scanner
        System.out.print("Enter the multiplication number you wnat to display: ");
        int num = multiplication.nextInt();
        System.out.println("\nMultiplication table of " + num);

        for (int i = 0 ; i <=10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }



        multiplication.close();
    }
}
