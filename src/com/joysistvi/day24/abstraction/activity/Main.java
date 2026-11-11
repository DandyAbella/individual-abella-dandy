package com.joysistvi.day24.abstraction.activity;

public class Main {

    public static void testPen(Pen pen) {
        System.out.println(pen);
        pen.write();
        pen.store();
        System.out.println();
    }

    public static void testRefillable(Refillable refillable) {
        refillable.refill();
        System.out.println("Maximum refills: "
                + Refillable.MAX_REFILLS);
        System.out.println();
    }

    public static void testClickable(Clickable clickable) {
        clickable.click();
        System.out.println();
    }

    public static void main(String[] args) {

        // This fails because Pen is now an abstract class
        // and abstract classes cannot be instantiated.
        // Pen pen = new Pen("Generic", "Blue", 15.0);

        Ballpen ballpen =
                new Ballpen("Pilot", "Black", 20.0, 1.0);

        Marker marker =
                new Marker("Pentel", "Red", 35.0, true);

        System.out.println(" testPen() ");
        testPen(ballpen);
        testPen(marker);

        System.out.println(" testRefillable() ");
        testRefillable(ballpen);
        testRefillable(marker);

        System.out.println(" testClickable() ");
        testClickable(ballpen);

        // This fails because Marker implements
        // Refillable only, not Clickable.
        // testClickable(marker);

        System.out.println(" Overloading ");
        ballpen.write("Hello ", 5);
        marker.write("Hello World Again");
    }
}

/*
Abstract Class (extends):
An abstract class can have both abstract and concrete methods.
It is used when child classes share common properties and behavior.
Child classes inherit it using extends.

Interface (implements):
An interface defines a contract that classes must follow.
It contains constants and abstract methods.
A class can implement multiple interfaces.
*/