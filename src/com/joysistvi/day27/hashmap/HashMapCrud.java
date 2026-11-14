package com.joysistvi.day27.hashmap;

import java.util.HashMap;

public class HashMapCrud {
    public static void main(String[] args) {
        HashMap <Integer, String> students = new HashMap<>();
        students.put(2026001, "Dandy aAbell");
        students.put(2026002, "abell dan");
        students.put(2026003, "dfaffdsf");

        System.out.println("Student 2026002: " + students.get(2026002));

        students.put(2026002, "my neam eis");
        System.out.println("Student 2026002: " + students.get(2026002));



    }
}
