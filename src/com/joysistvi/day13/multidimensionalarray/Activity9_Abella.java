package com.joysistvi.day13.multidimensionalarray;
import java.util.Scanner;

public class Activity9_Abella {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

               System.out.println("        Average Calculator");


        // Input number of students and subjects
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine(); // consume newline

        // Store subject names
        String[] subjectNames = new String[subjects];

        System.out.println("\nEnter subject names:");
        for (int i = 0; i < subjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            subjectNames[i] = sc.nextLine();
        }

        // Store student names and grades
        String[] studentNames = new String[students];
        double[][] grades = new double[students][subjects];
        double[] averages = new double[students];

        for (int i = 0; i < students; i++) {

            System.out.print("\nName of Student " + (i + 1) + ": ");
            studentNames[i] = sc.nextLine();

            System.out.println("Enter grades for each subject:");

            double total = 0;

            for (int j = 0; j < subjects; j++) {
                System.out.print(subjectNames[j] + ": ");
                grades[i][j] = sc.nextDouble();
                total += grades[i][j];
            }

            averages[i] = total / subjects;
            sc.nextLine(); // consume newline
        }

        // Display Report
              System.out.println("\n          Grades Report");


        System.out.printf("%-15s", "Student");

        for (int i = 0; i < subjects; i++) {
            System.out.printf("%-10s", subjectNames[i]);
        }

        System.out.printf("%-10s%n", "Average");

        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < students; i++) {

            System.out.printf("%-15s", studentNames[i]);

            for (int j = 0; j < subjects; j++) {
                System.out.printf("%-10.0f", grades[i][j]);
            }

            System.out.printf("%-10.2f%n", averages[i]);
        }

        sc.close();
    }
}
