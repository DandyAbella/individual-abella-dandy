package com.joysistvi.recordingstudio.view;

import com.joysistvi.recordingstudio.model.User;
import com.joysistvi.recordingstudio.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private UserService service;
    private Scanner scanner;

    public UserView(UserService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void displayAllUsers() {

        System.out.println("\n=== USERS ===");

        for (User user : service.getAllUsers()) {

            System.out.println(
                    user.getId()
                            + " | "
                            + user.getFullName()
                            + " | "
                            + user.getUserName()
            );
        }
    }

    public void promptCreateUser() {

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Username: ");
        String userName = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        service.createUser(
                fullName,
                userName,
                password
        );
    }

    public void promptFindUser() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        User user =
                service.findUserByUserName(username);

        if (user != null) {

            System.out.println(
                    user.getId()
                            + " | "
                            + user.getFullName()
                            + " | "
                            + user.getUserName()
            );
        } else {

            System.out.println("User not found.");
        }
    }
}