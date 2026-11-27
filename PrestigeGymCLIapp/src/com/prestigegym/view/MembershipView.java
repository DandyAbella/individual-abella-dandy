package com.prestigegym.view;

import com.prestigegym.model.Membership;
import com.prestigegym.service.MembershipService;
import com.prestigegym.service.MembershipServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MembershipView {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final MembershipService membershipService =
            new MembershipServiceImpl();

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== MEMBERSHIP REGISTRATION =====");
            System.out.println("1. Register Membership");
            System.out.println("2. View Memberships");
            System.out.println("3. Update Status");
            System.out.println("4. Cancel Membership");
            System.out.println("5. Back");

            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    registerMembership();
                    break;

                case "2":
                    viewMemberships();
                    break;

                case "3":
                    updateStatus();
                    break;

                case "4":
                    cancelMembership();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private static void registerMembership() {

        Membership membership = new Membership();

        System.out.print("Member ID: ");
        membership.setMemberId(
                Integer.parseInt(scanner.nextLine())
        );

        System.out.print("Plan ID: ");
        membership.setPlanId(
                Integer.parseInt(scanner.nextLine())
        );

        membership.setStartDate(LocalDate.now());

        System.out.print("End Date (YYYY-MM-DD): ");
        membership.setEndDate(
                LocalDate.parse(scanner.nextLine())
        );

        membership.setStatus("ACTIVE");

        membershipService.addMembership(membership);

        System.out.println(
                "Membership registered successfully."
        );
    }

    private static void viewMemberships() {

        List<Membership> memberships =
                membershipService.getAllMemberships();

        System.out.println();
        System.out.println("===== MEMBERSHIPS =====");

        for (Membership membership : memberships) {

            System.out.println(
                    membership.getId()
                            + " | Member "
                            + membership.getMemberId()
                            + " | Plan "
                            + membership.getPlanId()
                            + " | "
                            + membership.getStatus()
            );
        }
    }

    private static void updateStatus() {

        System.out.print("Membership ID: ");

        int id =
                Integer.parseInt(scanner.nextLine());

        Membership membership =
                membershipService.getMembershipById(id);

        if (membership == null) {

            System.out.println("Membership not found.");
            return;
        }

        System.out.print(
                "New Status (ACTIVE/EXPIRED): "
        );

        membership.setStatus(
                scanner.nextLine().toUpperCase()
        );

        membershipService.updateMembership(
                membership
        );

        System.out.println(
                "Membership updated successfully."
        );
    }

    private static void cancelMembership() {

        System.out.print("Membership ID: ");

        int id =
                Integer.parseInt(scanner.nextLine());

        membershipService.cancelMembership(id);

        System.out.println(
                "Membership cancelled successfully."
        );
    }
}