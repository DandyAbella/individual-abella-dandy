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
            System.out.println("5. View Archived Users");
            System.out.println("6. Restore User");
            System.out.println("7. Back");

            int choice = getChoice();

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

                    System.out.print("Enter User ID: ");
                    int id =
                            Integer.parseInt(scanner.nextLine());

                    User userToUpdate =
                            userService.findById(id);

                    if (userToUpdate == null) {

                        System.out.println("User not found.");
                        break;
                    }

                    System.out.print("First Name: ");
                    userToUpdate.setFirstName(
                            scanner.nextLine());

                    System.out.print("Last Name: ");
                    userToUpdate.setLastName(
                            scanner.nextLine());

                    System.out.print("Username: ");
                    userToUpdate.setUsername(
                            scanner.nextLine());

                    System.out.print("Email: ");
                    userToUpdate.setEmail(
                            scanner.nextLine());

                    System.out.print(
                            "Role (ADMIN/INSTRUCTOR/MEMBER): ");

                    userToUpdate.setRole(
                            scanner.nextLine().toUpperCase());

                    userService.updateUser(
                            userToUpdate);

                    break;

                case 4:

                    System.out.print(
                            "Enter User ID to archive: ");

                    int userId =
                            Integer.parseInt(scanner.nextLine());

                    userService.archiveUser(userId);

                    break;

                case 5:

                    List<User> archivedUsers =
                            userService.getArchivedUsers();

                    System.out.println();
                    System.out.println("===== ARCHIVED USERS =====");

                    for (User userRecord : archivedUsers) {

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

                case 6:

                    System.out.print(
                            "Enter User ID to restore: ");

                    int restoreId =
                            Integer.parseInt(scanner.nextLine());

                    userService.restoreUser(restoreId);

                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static final UserService userService =
            new UserServiceImpl();

    private static int getChoice() {

        while (true) {

            System.out.print("Choice: ");

            try {

                int choice =
                        Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= 7) {
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

