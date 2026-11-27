package com.prestigegym.view;

import com.prestigegym.model.Attendance;
import com.prestigegym.service.AttendanceService;
import com.prestigegym.service.AttendanceServiceImpl;

import java.util.List;
import java.util.Scanner;

public class AttendanceView {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final AttendanceService attendanceService =
            new AttendanceServiceImpl();

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== ATTENDANCE =====");
            System.out.println("1. Check In Member");
            System.out.println("2. Check Out Member");
            System.out.println("3. View Attendance");
            System.out.println("4. Back");

            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    checkIn();
                    break;

                case "2":
                    checkOut();
                    break;

                case "3":
                    viewAttendance();
                    break;

                case "4":
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private static void checkIn() {

        System.out.print("Member ID: ");

        int memberId =
                Integer.parseInt(scanner.nextLine());

        attendanceService.checkIn(memberId);

        System.out.println(
                "Check-in recorded successfully."
        );
    }

    private static void checkOut() {

        System.out.print("Attendance ID: ");

        int attendanceId =
                Integer.parseInt(scanner.nextLine());

        attendanceService.checkOut(attendanceId);

        System.out.println(
                "Check-out recorded successfully."
        );
    }

    private static void viewAttendance() {

        List<Attendance> attendances =
                attendanceService.getAllAttendance();

        System.out.println();
        System.out.println("===== ATTENDANCE RECORDS =====");

        if (attendances.isEmpty()) {

            System.out.println("No attendance records found.");
            return;
        }

        for (Attendance attendance : attendances) {

            System.out.println(
                    attendance.getId()
                            + " | Member ID: "
                            + attendance.getMemberId()
                            + " | Check In: "
                            + attendance.getCheckIn()
                            + " | Check Out: "
                            + attendance.getCheckOut()
            );
        }
    }
}