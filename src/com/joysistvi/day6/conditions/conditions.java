package com.joysistvi.day6.conditions;

public class conditions {
    public static void main (String[] args) {
        System.out.println ("hello world");

        //if
        //else
        //else if
        //switch

        int x = 20, y = 20;

        if (x < y) {
            System.out.println ("x is greater than y");
        } else {
            System.out.println ("x is not greater than y");
        }

        if (x < y) {
            System.out.println ("x is not greater than y");
        } else if (x == y) {
            System.out.println("x is equal to y");
        } else {
            System.out.println ("x is greater than y");
        }
    }
}
