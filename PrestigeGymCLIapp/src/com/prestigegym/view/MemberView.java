package com.prestigegym.view;

import com.prestigegym.model.Member;
import com.prestigegym.service.MemberService;
import com.prestigegym.service.MemberServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MemberView {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final MemberService memberService =
            new MemberServiceImpl();

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== MEMBER MANAGEMENT =====");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Update Member");
            System.out.println("4. Archive Member");
            System.out.println("5. Back");

            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addMember();
                    break;

                case "2":
                    viewMembers();
                    break;

                case "3":
                    updateMember();
                    break;

                case "4":
                    archiveMember();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void addMember() {

        Member member = new Member();

        System.out.print("First Name: ");
        member.setFirstName(scanner.nextLine());

        System.out.print("Last Name: ");
        member.setLastName(scanner.nextLine());

        System.out.print("Gender: ");
        member.setGender(scanner.nextLine());

        System.out.print("Contact Number: ");
        member.setContactNumber(scanner.nextLine());

        System.out.print("Email: ");
        member.setEmail(scanner.nextLine());

        System.out.print("Address: ");
        member.setAddress(scanner.nextLine());

        memberService.addMember(member);

        System.out.println("Member added successfully.");
    }

    private static void viewMembers() {

        List<Member> members =
                memberService.getAllMembers();

        System.out.println();
        System.out.println("===== MEMBERS =====");

        for (Member member : members) {

            System.out.println(
                    member.getId()
                            + " | "
                            + member.getFirstName()
                            + " "
                            + member.getLastName()
                            + " | "
                            + member.getGender()
                            + " | "
                            + member.getContactNumber()
            );
        }
    }

    private static void updateMember() {

        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Member member =
                memberService.getMemberById(id);

        if (member == null) {

            System.out.println("Member not found.");
            return;
        }

        System.out.print("First Name: ");
        member.setFirstName(scanner.nextLine());

        System.out.print("Last Name: ");
        member.setLastName(scanner.nextLine());

        System.out.print("Gender: ");
        member.setGender(scanner.nextLine());

        System.out.print("Contact Number: ");
        member.setContactNumber(scanner.nextLine());

        System.out.print("Email: ");
        member.setEmail(scanner.nextLine());

        System.out.print("Address: ");
        member.setAddress(scanner.nextLine());

        memberService.updateMember(member);

        System.out.println("Member updated successfully.");
    }

    private static void archiveMember() {

        System.out.print("Enter Member ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        memberService.archiveMember(id);

        System.out.println("Member archived successfully.");
    }
}