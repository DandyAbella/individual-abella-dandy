package com.prestigegym.view;

import java.util.Scanner;
import com.prestigegym.view.UserView;

public class AdminView {

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void display() {

        while(true){

            System.out.println();
            System.out.println("===== ADMIN MENU =====");
            System.out.println("1. User Management");
            System.out.println("2. Membership Plans");
            System.out.println("3. Fitness Categories");
            System.out.println("4. Activities");
            System.out.println("5. Logout");

            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){

                case 1:
                    UserView.display();
                    break;

                case 2:
                    System.out.println("Membership Plans");
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
}