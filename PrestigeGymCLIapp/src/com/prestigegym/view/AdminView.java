package com.prestigegym.view;

import java.util.Scanner;
import com.prestigegym.view.UserView;
import com.prestigegym.view.MembershipPlanView;

public class AdminView {

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== ADMIN MENU =====");
            System.out.println("1. User Management");
            System.out.println("2. Membership Plans");
            System.out.println("3. Fitness Categories");
            System.out.println("4. Activities");
            System.out.println("5. Logout");

            int choice = getChoice();

            switch (choice) {

                case 1:
                    UserView.display();
                    break;

                case 2:
                    MembershipPlanView.display();
                    break;

                case 3:
                    System.out.println("Fitness Categories");
                    break;

                case 4:
                    System.out.println("Activities");
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static int getChoice() {

        while (true) {

            System.out.print("Choice: ");

            try {

                int choice =
                        Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= 5) {
                    return choice;
                }

                System.out.println(
                        "Invalid option. Please enter 1-5.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number.");
            }
        }
    }


}