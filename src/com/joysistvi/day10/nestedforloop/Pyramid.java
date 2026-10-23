package com.joysistvi.day10.nestedforloop;

public class Pyramid {
    public static void main(String[] args) {
//
//        int rows = 5;
//
//        for (int i = 1; i <= rows; i++) {
//
//            // Print spaces
//            for (int j = 1; j <= rows - i; j++) {
//                System.out.println(" ");
//            }
//
//            // Print stars
//            for (int k = 1; k <= (2 * i - 1); k++) {
//                System.out.print("*");
//            }
//
//            // Move to next line
//            System.out.println();
//        }

        int rowss = 10;

        for (int i = 1; i <= rowss; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
