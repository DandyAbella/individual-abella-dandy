package com.joysistvi.day19.exceptionshandling;
import java.util.Scanner;

public class UssdLoadRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Dial the USSD code
        System.out.println("Dial *143# to access Globe Services");
        System.out.print("Enter USSD Code: ");
        String ussdCode = scanner.nextLine();

        // guard clause / early exit
        if (ussdCode != "*143#") {
            System.out.println("Invalid USSD Code!");
            return;
        }

        // 2. Main menu
        System.out.println();
        System.out.println("        * Load Registration *");
        System.out.println("    [1] Go+");
        System.out.println("    [2] Go");
        System.out.println("    [3] GoEXTRA");
        System.out.println("    [4] UNLI 5G");
        System.out.println("    [5] ALLNET");
        System.out.print("Enter a choice: ");
        int mainChoice = scanner.nextInt();

        String promoName = "";

        // 3. Promo sub-menus
        switch (mainChoice) {
            case 1:
                System.out.println();
                System.out.println("        *** Go+ Promos ***");
                System.out.println("    [1] Go+99");
                System.out.println("    [2] Go+129");
                System.out.println("    [3] Go+149");
                System.out.print("Enter a choice: ");
                int goPlusChoice = scanner.nextInt();

                switch (goPlusChoice) {
                    case 1:
                        promoName = "Go+99";
                        break;
                    case 2:
                        promoName = "Go+129";
                        break;
                    case 3:
                        promoName = "Go+149";
                        break;
                }
                break;

            case 2:
                System.out.println();
                System.out.println("        *** Go Promos ***");
                System.out.println("    [1] Go50");
                System.out.println("    [2] Go90");
                System.out.println("    [3] Go120");
                System.out.print("Enter a choice: ");
                int goChoice = scanner.nextInt();

                switch (goChoice) {
                    case 1:
                        promoName = "Go50";
                        break;
                    case 2:
                        promoName = "Go90";
                        break;
                    case 3:
                        promoName = "Go120";
                        break;
                }
                break;

            case 3:
                System.out.println();
                System.out.println("        *** GoEXTRA Promos ***");
                System.out.println("    [1] GoEXTRA99");
                System.out.println("    [2] GoEXTRA129");
                System.out.println("    [3] GoEXTRA149");
                System.out.print("Enter a choice: ");
                int goExtraChoice = scanner.nextInt();

                switch (goExtraChoice) {
                    case 1:
                        promoName = "GoEXTRA99";
                        break;
                    case 2:
                        promoName = "GoEXTRA129";
                        break;
                    case 3:
                        promoName = "GoEXTRA149";
                        break;
                }
                break;

            case 4:
                System.out.println();
                System.out.println("        *** UNLI 5G Promos ***");
                System.out.println("    [1] UNLI 5G 99");
                System.out.println("    [2] UNLI 5G 149");
                System.out.println("    [3] UNLI 5G 199");
                System.out.print("Enter a choice: ");
                int unli5gChoice = scanner.nextInt();

                switch (unli5gChoice) {
                    case 1:
                        promoName = "UNLI 5G 99";
                        break;
                    case 2:
                        promoName = "UNLI 5G 149";
                        break;
                    case 3:
                        promoName = "UNLI 5G 199";
                        break;
                }
                break;

            case 5:
                System.out.println();
                System.out.println("        *** ALLNET Promos ***");
                System.out.println("    [1] ALLNET99");
                System.out.println("    [2] ALLNET149");
                System.out.println("    [3] ALLNET199");
                System.out.print("Enter a choice: ");
                int allnetChoice = scanner.nextInt();

                switch (allnetChoice) {
                    case 1:
                        promoName = "ALLNET99";
                        break;
                    case 2:
                        promoName = "ALLNET149";
                        break;
                    case 3:
                        promoName = "ALLNET199";
                        break;
                }
                break;
        }

        // 4. Promo details menu
        System.out.println();
        System.out.println("        *** " + promoName + " Promo ***");
        System.out.println("-> Get 8 GB for all sites + 8GB");
        System.out.println("    [1] Subscribe");
        System.out.println("    [2] Exit");
        System.out.print("Enter a choice: ");
        int actionChoice = scanner.nextInt();

        switch (actionChoice) {
            case 1:
                System.out.println();
                System.out.println("You are now subscribed to " + promoName);
                break;
            case 2:
                break;
        }

        scanner.close();
    }
}