package com.prestigegym.view;

import com.prestigegym.model.Payment;
import com.prestigegym.service.PaymentService;
import com.prestigegym.service.PaymentServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class PaymentView {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final PaymentService paymentService =
            new PaymentServiceImpl();

    public static void display() {

        while (true) {

            System.out.println();
            System.out.println("===== PAYMENT MANAGEMENT =====");
            System.out.println("1. Add Payment");
            System.out.println("2. View Payments");
            System.out.println("3. Back");

            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addPayment();
                    break;

                case "2":
                    viewPayments();
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void addPayment() {

        Payment payment = new Payment();

        System.out.print("Reservation ID: ");
        payment.setReservationId(
                Integer.parseInt(scanner.nextLine())
        );

        System.out.println("Mode of Payment");
        System.out.println("1. CASH");
        System.out.println("2. E-WALLET");
        System.out.println("3. BANK TRANSFER");

        System.out.print("Mode ID: ");
        payment.setModeOfPaymentId(
                Integer.parseInt(scanner.nextLine())
        );

        System.out.print("Amount: ");
        payment.setAmount(
                new BigDecimal(scanner.nextLine())
        );

        System.out.print("Reference Number: ");
        payment.setReferenceNumber(
                scanner.nextLine()
        );

        payment.setPaymentStatus("PAID");

        paymentService.addPayment(payment);

        System.out.println();
        System.out.println(
                "Payment recorded successfully."
        );
    }

    private static void viewPayments() {

        List<Payment> payments =
                paymentService.getAllPayments();

        System.out.println();
        System.out.println("===== PAYMENTS =====");

        for (Payment payment : payments) {

            System.out.println(
                    payment.getId()
                            + " | Reservation "
                            + payment.getReservationId()
                            + " | Amount: PHP "
                            + payment.getAmount()
                            + " | "
                            + payment.getPaymentStatus()
            );
        }
    }
}
