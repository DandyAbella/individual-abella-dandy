package com.joysistvi.day15.mathclass;
import java.util.Scanner;
public class Activity11_Abella {
    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);

        //Math.abs() - returns the absolute (positive) value of a number
        int num = -33;
        System.out.println("the absolute value of " + num + " is " + Math.abs(num));

        //Math.max() - returns the larger of two values only
        int num1 = 666, num2 = 44;
        System.out.println(Math.max(num1, num2) + " is the larger of the two values " + num1 + " and " + num2);

        //Math.min() - returns the smaller of two values
        System.out.println(Math.min(num1, num2) + " is the smaller of the two values " + num1 + " and " + num2);

        //Math.pow() - raises a number to a specified power
        int base = 3, exponent = 4; //Math.pow(base, exponent)
        System.out.println("Math.power(base, exponent), so the" + " Math.pow(" + base + ", " + exponent + ") is " + Math.pow(3, 4));

        //Math.sqrt() - returns the square root of a number
        int squareRoot = 81;
        System.out.println("the square root of " + squareRoot + " is " + Math.sqrt(squareRoot));

        //Math.round() - rounds a decimal number to the nearest whole number
        double round = 5.6;
        System.out.println("the Math.round() of " + round + " is " + Math.round(round));

        //Math.ceil() - rounds a number up to the next whole number
        System.out.println("the Math.ceil() of " + round + " is " + Math.ceil(round));

        //Math.floor() - rounds a number down to the nearest whole number
        System.out.println("the Math.floor() of " + round + " is " + Math.floor(round));

        //Math.random() - generates a random number from 0.0 to less than 1.0
        System.out.println("ramdom generated number from 0.0 to less than 1.0 of Math.random() is " + Math.random());

        //Math.log() - returns the natural logarithm (base e) of a number
        int log = 10;
        System.out.println("the natural logarithm (base e) of " + log + " is " + Math.log(log));

        //Math.log10() - returns the base -10 logarithm of a number
        System.out.println("the base -10 logarithm of " + log + " is " + Math.log10(log));

        //Math.exp() - returns e raised to the power of a number
        double eEulersNumber = 2.718281828459045d;
        int power = 2;
        System.out.println("the value of Euler's Number (e) raised to the power of " + power + " is " + Math.exp(power));

        //Math.sin() - return the sine of an angle in radians
        double angle = 30d;
        System.out.println("the sine of angle " + angle + " is " + Math.sin(Math.toRadians(30)));

        //Math.cos() - returns the cosine of an angel in radians
        System.out.println("the cosine of angle " +angle + " is " + Math.cos(Math.toRadians(60)));

        //Math.tan() - returns the tangent of an angle in radians
        System.out.println("the tangent of angle " + angle + " is " + Math.tan(Math.toRadians(45)));

        //presentation
        System.out.print("\nEnter a number to get the square root value: ");
        double result = value.nextDouble();
        System.out.println("the square root of " + result + " is " + Math.sqrt(result));



            value.close();;
    }
}
