package com.joysistvi.day23.polymorphism.activity;

public class Main {

    public static void testPen(Pen pen) {
        System.out.println(pen);
        pen.write();
        pen.refill();
        System.out.println();
    }

    public static void main(String[] args) {

        // Runtime Polymorphism
        Pen pen1 = new Pen("Generic", "Blue", 15.0);
        Pen pen2 = new Ballpen("Pilot", "Black", 20.0, 1.0);
        Pen pen3 = new Marker("Pentel", "Red", 35.0, true);

        System.out.println("=== Calling methods on Pen references ===");

        System.out.println(" Pen ");
        pen1.write();
        pen1.refill();
        System.out.println();

        System.out.println(" Ballpen ");
        pen2.write();
        pen2.refill();
        System.out.println();

        System.out.println(" Marker ");
        pen3.write();
        pen3.refill();
        System.out.println();

        System.out.println(" testPen() ");
        testPen(pen1);
        testPen(pen2);
        testPen(pen3);

        System.out.println(" Overloading ");

        // Using child object in a Pen reference
        Pen pen4 = new Marker("Sharpie", "Green", 30.0, false);

        pen4.write("Hello ", 5);
        pen4.write("Hello world again", 4);
    }
}

/*
Method Overloading occurs when methods have the same name
but different parameter lists. It is resolved during compile time.

Method Overriding occurs when a child class provides its own
implementation of a method inherited from a parent class.
It is resolved during runtime through polymorphism.
*/