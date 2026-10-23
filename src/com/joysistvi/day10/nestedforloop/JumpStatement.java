package com.joysistvi.day10.nestedforloop;

public class JumpStatement {
    public static void main(String[] args) {
        //breaksatement

        for (int i = 0; i < 10; i++) {


            if  (i == 4) {
                break; //terminate the loop
            }
            System.out.println(i);
        }

        for (int j = 0; j < 10; j++) {
            if (j == 4) {
                continue;
            }
            System.out.println("hello");
        }


    }
}
