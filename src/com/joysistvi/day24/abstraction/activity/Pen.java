package com.joysistvi.day24.abstraction.activity;

public abstract class Pen {

    private String brand;
    private String color;
    private double weightInGrams;

    public Pen(String brand, String color, double weightInGrams) {
        this.brand = brand;
        this.color = color;
        this.weightInGrams = weightInGrams;
    }

    // Abstract method
    public abstract void write();

    // New regular method
    public void store() {
        System.out.println("Storing the pen in the pencil case.");
    }

    // Overloaded methods
    public void write(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(text);
        }
        System.out.println();
    }

    public void write(String text) {
        System.out.println(text);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(double weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    @Override
    public String toString() {
        return "Brand: " + brand +
                "\nColor: " + color +
                "\nWeight in Grams: " + weightInGrams;
    }
}