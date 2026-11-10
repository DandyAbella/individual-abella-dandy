package com.joysistvi.day22.inheritance.activity15;

public class Main {
    public static void main(String[] args) {

        Ballpen ballpen = new Ballpen(
                "Pilot",
                "Black",
                20.0,
                1.0
        );

        Marker marker = new Marker(
                "Pentel",
                "Red",
                35.0,
                true
        );

        System.out.println("=== Ballpen ===");
        System.out.println(ballpen);
        ballpen.write();

        System.out.println();

        System.out.println("=== Marker ===");
        System.out.println(marker);
        marker.write();
    }
}