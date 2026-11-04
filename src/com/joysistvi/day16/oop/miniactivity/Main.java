package com.joysistvi.day16.oop.miniactivity;

public class Main {
    public static void main(String[] args) {

        Ballpen ballpen = new Ballpen();
        ballpen.brand = "Pilot";
        ballpen.color = "blue";
        ballpen.price = 5;

        ballpen.waterProof();
        ballpen.write();
        ballpen.draw();

        Ballpen ballpen1 = new Ballpen();
        ballpen1.brand = "Panda";
        ballpen1.color = "Black";
        ballpen1.price = 4;

        ballpen1.draw();
        ballpen1.write();

        Ballpen ballpen2 = new Ballpen();
        ballpen2.brand = "Uniball";
        ballpen2.color = "green";
        ballpen2.price = 3;


    }

}
