package com.joysistvi.day22.inheritance.activity15;

public class Pen {

    private String brand;
    private String color;
    private double weigthInGrams;

    public Pen (String brand, String color, double weigthInGrams) {
        this.brand = brand;
        this.color = color;
        this. weigthInGrams = weigthInGrams;
    }

    //getters
    public  String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public double getWeigthInGrams() {
        return weigthInGrams;
    }

    //setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeigthInGrams(double weigthInGrams) {
        this.weigthInGrams = weigthInGrams;
    }

    public void write() {
        System.out.println("Writing with pen");
    }

    @Override
    public String toString() {
        return "Brand: " + brand +
                "\nColor: " + color +
                "\nWeigth in grams: " + weigthInGrams;
    }

}
