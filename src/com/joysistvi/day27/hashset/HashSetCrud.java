package com.joysistvi.day27.hashset;

import java.util.HashSet;
import java.util.Random;
<<<<<<< HEAD
import java.util.Set;


public class HashSetCrud {

    public static void main(String[] args) {
        // Lotto Simulator
//        HashSet<Integer> lottoNumbers = new HashSet<>();
//        Random random = new Random();
//
//        System.out.println("=== Lotto Simulator ===");
//
//        // 0
//        while (lottoNumbers.size() < 6) {
//            lottoNumbers.add(random.nextInt(58) + 1);
//
//        }
//
//        System.out.println(lottoNumbers);

        Set<Integer> bingoNumbers = new HashSet<>();
        Random random = new Random();

        String letter;
        int roll = random.nextInt(75) + 1;

        if (roll < 16) {
            letter = "B";
        } else if (roll < 31) {
            letter = "I";
        } else if (roll < 46) {
            letter = "N";
        } else if (roll < 61) {
            letter = "G";
        } else {
            letter = "O";
        }

        System.out.println("Sa letra ng " + letter + " : " + roll);
=======

public class HashSetCrud {
    public static void main(String[] args) {
        HashSet<Integer> lottoNumbers = new HashSet<>();
        Random random = new Random();

        System.out.println("*** Lotto Simulator **");

        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(random.nextInt(58) + 1);
        }
        System.out.println(lottoNumbers);

        HashSet<Integer> bingoNumbers = new HashSet<>();
        while (bingoNumbers.size() < 5) {
            bingoNumbers.add(random.nextInt(65));
        }
        System.out.println(bingoNumbers);
>>>>>>> 0e00169ce83cc2fd5c45af836ee5209f09f45b4c
    }
}

/*
<<<<<<< HEAD
HashSet<Integer> evenNumbers = new HashSet<>();

        // Create item(s)
=======
//create items
>>>>>>> 0e00169ce83cc2fd5c45af836ee5209f09f45b4c
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        evenNumbers.add(8);
        evenNumbers.add(10);
<<<<<<< HEAD
        evenNumbers.add(10);

        // Delete an item / Delete all items
//        evenNumbers.remove(10);
//        evenNumbers.removeAll(evenNumbers);
//        evenNumbers.clear();

        evenNumbers.contains(10);

        // Print all the elements
        evenNumbers.forEach(System.out::println);
=======

        //delete an items
        evenNumbers.remove(10);

        //print all elements
        evenNumbers.forEach(System.out::println);

>>>>>>> 0e00169ce83cc2fd5c45af836ee5209f09f45b4c
 */
