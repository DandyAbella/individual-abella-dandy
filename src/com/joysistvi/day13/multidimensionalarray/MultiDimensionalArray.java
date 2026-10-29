package com.joysistvi.day13.multidimensionalarray;
import java.util.Scanner;
public class MultiDimensionalArray {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        int numStudents;
        int numSubjects;

        System.out.println(" **Average Calculator**");
        // enters how many numbers of students & subjects
        System.out.print("Enter number of students: ");
        numStudents = sc.nextInt();
        System.out.print("Enter number of subjects: ");
        numSubjects = sc.nextInt();
        sc.nextLine();

        String[] SubjectNames = new String[numSubjects];
        // enter names of subjects
        System.out.println("\n **Enter subject Names**");
        for (int i = 0; i < numSubjects; i++) {
         System.out.print("Subject: " + (i + 1) + ": ");
         SubjectNames[i] = sc.nextLine();
        }

        //stores student names and grades
//     String [] StudentNames = new String[];






sc.close();
    }
}
