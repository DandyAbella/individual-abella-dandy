package com.joysistvi.day27.hashset;

import java.util.HashSet;
import java.util.Random;

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
    }
}

/*
//create items
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        evenNumbers.add(8);
        evenNumbers.add(10);

        //delete an items
        evenNumbers.remove(10);

        //print all elements
        evenNumbers.forEach(System.out::println);

 */
