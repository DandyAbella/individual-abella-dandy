package com.joysistvi.day10.nestedforloop;

import java.util.Scanner;

public class activity7_Abella {
    public static void main(String[] args) {

        //multiplication table using nested loop

        for (int j = 1; j <= 10; j++) {
            System.out.println("\nMultiplication table of " + j);
            for (int k = 1; k <= 10; k++) {
                System.out.println((j + " x " + k + " = " + (j * k)));
            }
        }


    }
}
