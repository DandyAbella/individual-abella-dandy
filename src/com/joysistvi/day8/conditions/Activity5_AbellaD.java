package com.joysistvi.day8.conditions;
import java.util.Scanner;
public class Activity5_AbellaD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ussd;

        // Step 1: Dial USSD Code
        System.out.println("Dial *143# to access Globe Services");
        do {
            System.out.print("Enter USSD Code: ");
            ussd = sc.nextLine();
            if (!ussd.equals("*143#")) {
                System.out.println("Invalid USSD Code. Try again.");
            }
        } while (!ussd.equals("*143#"));

        // Step 2: Main Menu
        System.out.println("\n\t* Load Registration *");
        System.out.println("[1] Go+");
        System.out.println("[2] Go");
        System.out.println("[3] GoEXTRA");
        System.out.println("[4] UNLI 5G");
        System.out.println("[5] ALLNET");
        System.out.print("Enter a choice: ");
        int mainChoice = sc.nextInt();

        // Step 3: Sub-menus
        int promoChoice;
        String promoName = "";
        String promoDetails = "";

        switch (mainChoice) {
            case 1:
                System.out.println("\n\t*** Go+ Promos ***");
                System.out.println("[1] Go+99");
                System.out.println("[2] Go+129");
                System.out.println("[3] Go+149");
                System.out.print("Enter a choice: ");
                promoChoice = sc.nextInt();
                if (promoChoice == 1) {
                    promoName = "Go+99";
                    promoDetails = "-> Get 8 GB for all sites + 8GB";
                } else if (promoChoice == 2) {
                    promoName = "Go+129";
                    promoDetails = "-> Get 10 GB for all sites + 10GB";
                } else if (promoChoice == 3) {
                    promoName = "Go+149";
                    promoDetails = "-> Get 12 GB for all sites + 12GB";
                }
                break;

            case 2:
                System.out.println("\n\t*** Go Promos ***");
                System.out.println("[1] Go50");
                System.out.println("[2] Go90");
                System.out.println("[3] Go120");
                System.out.print("Enter a choice: ");
                promoChoice = sc.nextInt();
                if (promoChoice == 1) {
                    promoName = "Go50";
                    promoDetails = "-> Get 5 GB for all sites";
                } else if (promoChoice == 2) {
                    promoName = "Go90";
                    promoDetails = "-> Get 8 GB for all sites";
                } else if (promoChoice == 3) {
                    promoName = "Go120";
                    promoDetails = "-> Get 10 GB for all sites";
                }
                break;

            case 3:
                System.out.println("\n\t*** GoEXTRA Promos ***");
                System.out.println("[1] GoEXTRA99");
                System.out.println("[2] GoEXTRA129");
                System.out.println("[3] GoEXTRA149");
                System.out.print("Enter a choice: ");
                promoChoice = sc.nextInt();
                if (promoChoice == 1) {
                    promoName = "GoEXTRA99";
                    promoDetails = "-> Get 8 GB + Unlimited Calls to Globe/TM";
                } else if (promoChoice == 2) {
                    promoName = "GoEXTRA129";
                    promoDetails = "-> Get 10 GB + Unlimited Calls to Globe/TM";
                } else if (promoChoice == 3) {
                    promoName = "GoEXTRA149";
                    promoDetails = "-> Get 12 GB + Unlimited Calls to Globe/TM";
                }
                break;

            case 4:
                System.out.println("\n\t*** UNLI 5G Promos ***");
                System.out.println("[1] UNLI 5G 99");
                System.out.println("[2] UNLI 5G 149");
                System.out.println("[3] UNLI 5G 199");
                System.out.print("Enter a choice: ");
                promoChoice = sc.nextInt();
                if (promoChoice == 1) {
                    promoName = "UNLI 5G 99";
                    promoDetails = "-> Unlimited 5G data for 1 day";
                } else if (promoChoice == 2) {
                    promoName = "UNLI 5G 149";
                    promoDetails = "-> Unlimited 5G data for 2 days";
                } else if (promoChoice == 3) {
                    promoName = "UNLI 5G 199";
                    promoDetails = "-> Unlimited 5G data for 3 days";
                }
                break;

            case 5:
                System.out.println("\n\t*** ALLNET Promos ***");
                System.out.println("[1] ALLNET99");
                System.out.println("[2] ALLNET149");
                System.out.println("[3] ALLNET199");
                System.out.print("Enter a choice: ");
                promoChoice = sc.nextInt();
                if (promoChoice == 1) {
                    promoName = "ALLNET99";
                    promoDetails = "-> Get 8 GB + Unlimited Calls to All Networks";
                } else if (promoChoice == 2) {
                    promoName = "ALLNET149";
                    promoDetails = "-> Get 10 GB + Unlimited Calls to All Networks";
                } else if (promoChoice == 3) {
                    promoName = "ALLNET199";
                    promoDetails = "-> Get 12 GB + Unlimited Calls to All Networks";
                }
                break;

            default:
                System.out.println("Invalid choice. Exiting...");
                sc.close();
                return;
        }

        // Step 4: Promo Details Menu
        System.out.println("\n\t*** " + promoName + " Promo ***");
        System.out.println(promoDetails);
        System.out.println("[1] Subscribe");
        System.out.println("[2] Exit");
        System.out.print("Enter a choice: ");
        int finalChoice = sc.nextInt();

        if (finalChoice == 1) {
            System.out.println("\nYou are now subscribed to " + promoName);
        } else {
            System.out.println("\nProgram ended.");
        }

        sc.close();
    }
}
