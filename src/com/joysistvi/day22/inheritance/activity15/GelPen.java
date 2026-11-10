package com.joysistvi.day22.inheritance.activity15;

public class GelPen extends Ballpen {
    private boolean waterproof;

    public GelPen(String brand, String color,
                  double weightInGrams,
                  double pointSize,
                  boolean waterproof) {

        super(brand, color, weightInGrams, pointSize);
        this.waterproof = waterproof;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    @Override
    public void write() {
        System.out.println("Writing smoothly with a waterproof gel pen.");
    }

    @Override
    public String toString() {
        return "Type: GelPen\n" +
                super.toString() +
                "\nWaterproof: " + (waterproof ? "Yes" : "No");
    }
}