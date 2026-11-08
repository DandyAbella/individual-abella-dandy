package com.joysistvi.day22.inheritance.activity15;

public class Ballpen extends Pen {
    private double pointSize;

    public Ballpen(String brand, String color, double weigthInGrams, double pointSize) {
        super(brand, color,weigthInGrams);
        this.pointSize = pointSize;
    }

    public double getPointSize() {
        return pointSize;
    }

    public void setPointSize(double pointSize) {
        this.pointSize = pointSize;
    }

    @Override
    public  String toString() {
        return "Type: Ballpen\n" +
                super.toString() +
                "\nPoint Size: " + pointSize;
    }
}
