package com.joysistvi.day10.nestedforloop;

public class NestedForLoop {
    public static void main(String[] args) {

        //syntax of nested  for loop
        //the inner loop executes completely whenever outer loop executes

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            for (int j = 1; j <=i; j++) {
                System.out.println("\t" + j);
            }
        }

//        for (int i =1; i <= 10; i++) {
//            System.out.println("Multiplication table of " + i);
//            for (int j = 1; j <= 10; j++) { //inner loop
//                System.out.println(i + " * " + j + " = " +(i * j));
//            }
//        }
//        System.out.println();

    }
}
