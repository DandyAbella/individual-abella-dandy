package com.joysistvi.day8.conditions;

import java.util.Scanner;

public class Activity5_Abella {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Load Registration Program
        System.out.print("Enter code: ");
        String ussdcode = sc.nextLine();  // read user input as string

        if (ussdcode.equals("*143#")) {
            System.out.println("Choose promo code");
            System.out.println("[1] Go +");
            System.out.println("[2] Go Smart");
            System.out.println("[3] Go 99");
            System.out.println("[4] Go 99 smart");
            System.out.println("[5] Go Smartsmart \n");

            //select promo options
            System.out.println("");
            int promoOptions = sc.nextInt();
            switch (promoOptions) {
                case 1:
                    System.out.println("[a]");
                    System.out.println("[b]");
                    break;
                case 2:
                    System.out.println("[i]");
                    System.out.println("ii");
                    break;
                default:
                    System.out.println("end...");
            }

        } else {
            System.out.println("bad");
        }

        sc.close();
    }
    }
