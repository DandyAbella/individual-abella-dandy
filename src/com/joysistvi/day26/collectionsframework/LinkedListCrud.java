package com.joysistvi.day26.collectionsframework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedListCrud {

    public static void main(String[] args) {
        List<String> dice = new LinkedList<>();
        System.out.println("**Color Games**");

        // Create / Add item(s)
        dice.add("Blue");
        dice.add("Green");
        dice.add("Pink");
        dice.add("White");
        dice.add("Red");
        dice.add("Yellow");

        for (int i = 0; i <= 2; i++) {
            Collections.shuffle(dice);
            System.out.println((i + 1) + " . " + dice.get(0));
        }


    }
}

//Exempted - Color Game

/*
 List<String> dice = new LinkedList<>();
        System.out.println("**Color Games**");

        // Create / Add item(s)
        dice.add("Blue");
        dice.add("Green");
        dice.add("Pink");
        dice.add("White");
        dice.add("Red");
        dice.add("Yellow");
        Collections.shuffle(dice);
        System.out.println(dice.get(0));

        List<String> dice2 = new LinkedList<>();
        dice2.addAll(dice);
        Collections.shuffle(dice2);
        System.out.println(dice2.get(0));

        List<String> dice3 = new LinkedList<>(dice2);
        System.out.println(dice3.get(0));
 */