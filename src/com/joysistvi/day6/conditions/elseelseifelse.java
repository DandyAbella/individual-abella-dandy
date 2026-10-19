package com.joysistvi.day6.conditions;
import java.util.Scanner;
public class elseelseifelse {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println ("Compare entered number: ");

        System.out.print("Enter number 1: ");
        int num1 = sc.nextInt();

        System.out.print ("Enter nubmer 2: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println ("num1 is greater than num2");
        } else if (num1 < num2) {
            System.out.println ("num 1 IS NOT greater than num2");
        } else {
            System.out.println ("num1 is equal to num2");
        }

    }
}
