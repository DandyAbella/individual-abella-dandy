package com.prestigegym.view;

import com.prestigegym.model.User;
import com.prestigegym.service.UserService;
import com.prestigegym.service.UserServiceImpl;
import com.prestigegym.view.AdminView;

import java.util.Scanner;

public class LoginView {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final UserService userService =
            new UserServiceImpl();

    public static void display() {

        System.out.println("===== PRESTIGE GYM =====");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user =
                userService.login(username, password);

        if(user == null){

            System.out.println("Invalid Credentials");
            return;
        }

        System.out.println("Welcome "
                + user.getFirstName());

        System.out.println("Role: "
                + user.getRole());

        if(user.getRole().equals("ADMIN")){

            AdminView.display();

        }

    }
}