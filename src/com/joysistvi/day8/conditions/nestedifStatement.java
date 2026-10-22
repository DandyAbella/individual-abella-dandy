package com.joysistvi.day8.conditions;
import java.util.Scanner;
public class nestedifStatement {

    public static void main(String[] args) {
        int age = 1;
        String category;

        if (age >=60){
            category = "senior";
        } else if (age >= 30) {
            category = "adult";
        } else if (age >= 15) {
            category = "young";
        } else {
            category = "child";
        }

        System.out.println ("age category: " + category);
        /*
        if (age <=1){
            category = "infant";
        } else if (age <= 2) {
            category = "toddler";
        } else {
            category = "child";
        }*/
    }
    }