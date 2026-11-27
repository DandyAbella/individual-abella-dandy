package com.prestigegym.view;

import java.util.Scanner;
import com.prestigegym.view.UserView;
import com.prestigegym.view.MembershipPlanView;
import com.prestigegym.view.MemberView;
import com.prestigegym.view.MembershipView;
import com.prestigegym.view.AttendanceView;
import com.prestigegym.view.PaymentView;

public class AdminView {

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== ADMIN MENU =====");
            System.out.println("1. User Management");
            System.out.println("2. Membership Plans");
            System.out.println("3. Member Management");
            System.out.println("4. Membership Registration");
            System.out.println("5. Attendance Tracking");
            System.out.println("6. Payment Management");
            System.out.println("7. Dashboard");
            System.out.println("8. Logout");

            int choice = getChoice();

            switch (choice) {

                case 1:
                    UserView.display();
                    break;

                case 2:
                    MembershipPlanView.display();
                    break;

                case 3:
                    MemberView.display();
                    break;

                case 4:
                    MembershipView.display();
                    break;

                case 5:
                    AttendanceView.display();
                    break;

                case 6:
                    PaymentView.display();
                    break;

                case 7:
                    DashboardView.display();
                    break;

                case 8:
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

                if (choice >= 1 && choice <= 6) {
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