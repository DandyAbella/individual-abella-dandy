package com.joysistvi.day16.oop.miniactivity;

import java.util.SplittableRandom;

public class Ballpen {
    String brand;
    String color;
    double price;

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
    }

    void write() {
        System.out.println(brand + " is writing");
    }
    void draw() {
        System.out.println(brand + " can use to draw");
    }
    void waterProof() {
        System.out.println(brand + " is waterproof");
    }
}
