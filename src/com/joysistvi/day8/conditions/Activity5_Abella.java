package com.joysistvi.day8.conditions;

import java.util.Scanner;   //telling java that we what to use class from other package
                            //java.util = package // .Scanner = specific class

public class Activity5_Abella {
    public static void main(String[] args) {

        Scanner userinput = new Scanner(System.in);   //
                // userinput = variable name = object reference

        System.out.print("Enter your name: ");
        String userName = userinput.nextLine();
        System.out.print("Welcome " + userName);

        //Dial USSD Code
        System.out.println();
        System.out.println("\n * Dial *143# to access Globe Services *");
        System.out.print("Enter USSD Code: ");
        String ussdcode = userinput.nextLine();

        if (ussdcode.equals("*143#")){
            System.out.println();
            System.out.println("Load Registration");
            System.out.println("[1] Go +");
            System.out.println("[2] Go");
            System.out.println("[3] GoExtra");
            System.out.println("[4] UNLI 5G");
            System.out.println("[5] ALLNET");
            System.out.print("Enter a choice: ");
            int promo = userinput.nextInt();

            switch (promo) {
                case 1:
                    System.out.println();
                    System.out.println("Go + promos");
                    System.out.println("[1] Go+99");
                    System.out.println("[2] Go+129");
                    System.out.println("[3] Go+149");
                    System.out.print("Enter a choice: ");
                    int one = userinput.nextInt();
                        if (one == 1) {
                            System.out.println();
                            System.out.println("Go+99");
                            System.out.println("Get 8 GB for all sites");
                            System.out.println("[1] Subscribe");
                            System.out.println("[2] Exit");
                            System.out.print("Enter a choice: ");
                            int oneone = userinput.nextInt();
                                if (oneone == 1) {
                                    System.out.println("You are now subscribe to Go+99");
                                } else {
                                    System.out.println("Cancelled!");
                                }
                        } else if (one == 2) {
                            System.out.println();
                            System.out.println("Go+129");
                            System.out.println("Get 12 GB for all sites");
                            System.out.println("[1] Subscribe");
                            System.out.println("[2] Exit");
                            System.out.print("Enter a choice: ");
                            int onetwo = userinput.nextInt();
                            if (onetwo == 1) {
                                System.out.println("You are now subscribe to Go+129");
                            } else {
                                System.out.println("Cancelled!");
                            }
                        } else if (one == 3) {
                            System.out.println();
                            System.out.println("Go+149");
                            System.out.println("Get 16 GB for all sites");
                            System.out.println("[1] Subscribe");
                            System.out.println("[2] Exit");
                            System.out.print("Enter a choice: ");
                            int onethree = userinput.nextInt();
                            if (onethree == 1) {
                                System.out.println("You are now subscribe to Go+149");
                            } else {
                                System.out.println("Cancelled!");
                            }
                        } else {

                        }
                    break;

                case 2:
                    System.out.println("Go promos");
                    System.out.println("[1] Go50");
                    System.out.println("[2] Go+90");
                    System.out.println("[3] Go+120");
                    int two = userinput.nextInt();
                    if (two == 1) {
                        System.out.println();
                        System.out.println("Go50");
                        System.out.println("Get 8 GB for all sites");
                        System.out.println("[1] Subscribe");
                        System.out.println("[2] Exit");
                        System.out.print("Enter a choice: ");
                        int twoone = userinput.nextInt();
                        if (twoone == 1) {
                            System.out.println("You are now subscribe to Go50");
                        } else {
                            System.out.println("Cancelled!");
                        }
                    } else if (two == 2) {
                        System.out.println();
                        System.out.println("Go90");
                        System.out.println("Get 12 GB for all sites");
                        System.out.println("[1] Subscribe");
                        System.out.println("[2] Exit");
                        System.out.print("Enter a choice: ");
                        int twotwo = userinput.nextInt();
                        if (twotwo == 1) {
                            System.out.println("You are now subscribe to Go90");
                        } else {
                            System.out.println("Cancelled!");
                        }
                    } else if (two == 3) {
                        System.out.println();
                        System.out.println("Go+120");
                        System.out.println("Get 16 GB for all sites");
                        System.out.println("[1] Subscribe");
                        System.out.println("[2] Exit");
                        System.out.print("Enter a choice: ");
                        int twothree = userinput.nextInt();
                        if (twothree == 1) {
                            System.out.println("You are now subscribe to Go120");
                        } else {
                            System.out.println("Cancelled!");
                        }
                    } else {

                    }

                    break;

                case 3:
                    System.out.println("Go Extra promos");
                    System.out.println("[1] Go Extra 99");
                    System.out.println("[2] Go Extra 129");
                    System.out.println("[3] Go Extra 149");
                    break;

                case 4:
                    System.out.println("UNLI 5G promos");
                    System.out.println("[1] UNLI 5G 99");
                    System.out.println("[2] UNLI 5G 129");
                    System.out.println("[3] UNLI 5g 149");
                    break;

                case 5:
                    System.out.println("ALLNET promos");
                    System.out.println("[1] ALLNET99");
                    System.out.println("[2] ALLNET129");
                    System.out.println("[3] AlLNET 149");
                    break;

                default:
                    System.out.println("error");
                    userinput.close();
            }

        } else {
            System.out.println("error");
        }


        userinput.close(); // tells java that we are done entering data.
    }
}
