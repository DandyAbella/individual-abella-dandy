package com.prestigegym.view;

import com.prestigegym.model.MembershipPlan;
import com.prestigegym.service.MembershipPlanService;
import com.prestigegym.service.MembershipPlanServiceImpl;

import java.util.List;

import java.util.Scanner;

public class MembershipPlanView {

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== MEMBERSHIP PLANS =====");

            System.out.println("1. Add Plan");
            System.out.println("2. View Plans");
            System.out.println("3. Update Plan");
            System.out.println("4. Archive Plan");
            System.out.println("5. Back");

            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Add Plan");
                    break;

                case "2":

                    List<MembershipPlan> plans =
                            membershipPlanService.getAllPlans();

                    System.out.println();
                    System.out.println("===== MEMBERSHIP PLANS =====");

                    for (MembershipPlan plan : plans) {

                        System.out.println(
                                plan.getId()
                                        + " | "
                                        + plan.getPlanName()
                                        + " | "
                                        + plan.getDurationMonths()
                                        + " Month(s)"
                                        + " | PHP "
                                        + plan.getPrice()
                        );
                    }

                    break;

                case "3":
                    System.out.println("Update Plan");
                    break;

                case "4":
                    System.out.println("Archive Plan");
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static final MembershipPlanService
            membershipPlanService =
            new MembershipPlanServiceImpl();

}