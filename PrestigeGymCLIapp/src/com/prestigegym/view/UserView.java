package com.prestigegym.view;

import com.prestigegym.model.User;
import com.prestigegym.service.UserService;
import com.prestigegym.service.UserServiceImpl;
import java.util.List;

import java.util.Scanner;

public class UserView {

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== USER MANAGEMENT =====");

            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Archive User");
            System.out.println("5. Back");

            System.out.print("Choice: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    User user = new User();

                    System.out.print("First Name: ");
                    user.setFirstName(scanner.nextLine());

                    System.out.print("Last Name: ");
                    user.setLastName(scanner.nextLine());

                    System.out.print("Username: ");
                    user.setUsername(scanner.nextLine());

                    System.out.print("Email: ");
                    user.setEmail(scanner.nextLine());

                    System.out.print("Password: ");
                    user.setPassword(scanner.nextLine());

                    System.out.print("Role (ADMIN/INSTRUCTOR/MEMBER): ");
                    user.setRole(scanner.nextLine().toUpperCase());

                    userService.saveUser(user);

                    break;

                case 2:

                    List<User> users =
                            userService.getAllUsers();

                    System.out.println();
                    System.out.println("===== USERS =====");

                    for (User userRecord : users) {

                        System.out.println(
                                userRecord.getId()
                                        + " | "
                                        + userRecord.getFirstName()
                                        + " "
                                        + userRecord.getLastName()
                                        + " | "
                                        + userRecord.getUsername()
                                        + " | "
                                        + userRecord.getRole()
                        );
                    }

                    break;

                case 3:
                    System.out.println("Update User");
                    break;

                case 4:
                    System.out.println("Archive User");
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static final UserService userService =
            new UserServiceImpl();

}