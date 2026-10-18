package com.joysistvi.day4.operators;


public class Activity2_Abella {
        public static void main(String[] args) {
        //given values >>> shows some ways to declare a variables
        double income = 50_000, foodAllowance = 15_000; // using underscores(_) is nice features in numeric literals for readability
        double transportation = 2500, rent = 4500, utilityBill = 3500;
        double remainingBalance;
        double utilityBillPercentage = income / utilityBill;

        System.out.println("Income: " + Math.round(income));
        System.out.println("Food Allowance: " + foodAllowance / income * 100 + "%");
        System.out.println("Transportation: " + transportation / income * 100 + "%");
        System.out.println("Rent: " + rent / income * 100 + "%");

        //using printf, it controls how the value is displayed using format specifiers (%.1f%%)
        // " %.1f%% " means format the numbers as floating point with 1 decimal places, and immediately followed with literal % sign
        System.out.printf("Utility Bill: %.1f%%\n", utilityBillPercentage);

        // Math.round is method in java that converts float/double into int/long or decimal value to whole number value
        //using %,d\n specifier with groupings %,d for integers, %,.0f for decimals to whole... in here, i use %,d\n to put comma in thousands value
        //using specifier, the plus + sign that we use to concat does not work in someway, use comma (,)
        System.out.printf("Remaining Balance: %,d\n", Math.round(income - foodAllowance - transportation- rent - utilityBill));


    }
}
