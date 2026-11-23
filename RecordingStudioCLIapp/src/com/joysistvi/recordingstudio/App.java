
package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.model.User;

import com.joysistvi.recordingstudio.repository.AlbumRepositoryImpl;
import com.joysistvi.recordingstudio.repository.ArtistRepositoryImpl;
import com.joysistvi.recordingstudio.repository.PlaylistRepositoryImpl;
import com.joysistvi.recordingstudio.repository.SongRepositoryImpl;
import com.joysistvi.recordingstudio.repository.UserRepository;
import com.joysistvi.recordingstudio.repository.UserRepositoryImpl;

import com.joysistvi.recordingstudio.service.AlbumService;
import com.joysistvi.recordingstudio.service.AlbumServiceImpl;
import com.joysistvi.recordingstudio.service.ArtistService;
import com.joysistvi.recordingstudio.service.ArtistServiceImpl;
import com.joysistvi.recordingstudio.service.PlaylistService;
import com.joysistvi.recordingstudio.service.PlaylistServiceImpl;
import com.joysistvi.recordingstudio.service.SongService;
import com.joysistvi.recordingstudio.service.SongServiceImpl;
import com.joysistvi.recordingstudio.service.UserService;
import com.joysistvi.recordingstudio.service.UserServiceImpl;

import com.joysistvi.recordingstudio.util.ClearScreen;
import com.joysistvi.recordingstudio.view.AlbumView;
import com.joysistvi.recordingstudio.view.ArtistView;
import com.joysistvi.recordingstudio.view.PlaylistView;
import com.joysistvi.recordingstudio.view.SongView;
import com.joysistvi.recordingstudio.view.UserView;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        System.out.println("\n*** User ***");
        System.out.println("[1] Register");
        System.out.println("[2] Login");
        System.out.println("[0] Exit");

        int choice = getValidChoice(sc, "Enter your choice: ", 0, 1, 2);

        switch (choice) {

            case 1:

                ClearScreen.clearScreen();

                System.out.print("\nEnter full name: ");
                String full_name = sc.nextLine();

                System.out.print("Enter user name: ");
                String user_name = sc.nextLine();

                System.out.print("Enter user password: ");
                String user_password = sc.nextLine();

                System.out.print("Enter role (ADMIN/USER): ");
                String role = sc.nextLine();

                userService.createUser(
                        full_name,
                        user_name,
                        user_password,
                        role
                );

                break;


            case 2:

                ClearScreen.clearScreen();

                System.out.println("\n=== LOGIN ===");

                boolean success = false;
                String userName = "";
                String password = "";

                // Allow only 2 login attempts
                for (int attempt = 1; attempt <= 2; attempt++) {

                    System.out.println("\nLogin Attempt " + attempt + " of 2");

                    System.out.print("Username: ");
                    userName = sc.nextLine();

                    System.out.print("Password: ");
                    password = sc.nextLine();

                    success = userService.login(userName, password);

                    if (success) {
                        break;
                    }

                    System.out.println("\nInvalid username or password!");

                    if (attempt == 1) {
                        System.out.println("You have one more attempt. Please try again.");
                    }
                }

                if (success) {

                    ClearScreen.clearScreen();

                    User user = userService.findUserByUserName(userName);

                    System.out.println("\nLogin successful!");

                    if ("ADMIN".equalsIgnoreCase(user.getRole())) {

                        System.out.println("Welcome Administrator");

                        UserView userView = new UserView(userService);
                        userView.showMenu();

                    } else {

                        System.out.println("Welcome User");
                        showUserMenu(sc);
                    }

                } else {

                    System.out.println("\nMaximum login attempts reached!");
                    System.out.println("Returning to main menu...");
                }

                break;


            case 0:

                System.out.println("Goodbye!");

                break;
        }
    }




    // INPUT VALIDATION METHOD

    private static int getValidChoice(
            Scanner sc,
            String prompt,
            int... validChoices) {

        while (true) {

            System.out.print(prompt);

            String input = sc.nextLine().trim();

            try {

                int choice = Integer.parseInt(input);

                for (int validChoice : validChoices) {

                    if (choice == validChoice) {
                        return choice;
                    }
                }

                System.out.println(
                        "Invalid option! Please select from the menu."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter numbers only."
                );
            }

            System.out.println("Please try again.\n");
        }
    }


    // USER MENU

    private static void showUserMenu(Scanner sc) {

        int choice;

        do {

            System.out.println("\n=== USER MENU ===");
            System.out.println("1. View Artists");
            System.out.println("2. View Albums");
            System.out.println("3. View Songs");
            System.out.println("4. View Playlists");
            System.out.println("0. Logout");

            choice = getValidChoice(
                    sc,
                    "Choice: ",
                    0, 1, 2, 3, 4
            );

            switch (choice) {

                case 1:

                    ArtistService artistService =
                            new ArtistServiceImpl(
                                    new ArtistRepositoryImpl()
                            );

                    ArtistView artistView =
                            new ArtistView(artistService);

                    artistView.displayAllArtists();

                    break;


                case 2:

                    AlbumService albumService =
                            new AlbumServiceImpl(
                                    new AlbumRepositoryImpl()
                            );

                    AlbumView albumView =
                            new AlbumView(albumService);

                    albumView.displayAllAlbums();

                    break;


                case 3:

                    SongService songService =
                            new SongServiceImpl(
                                    new SongRepositoryImpl()
                            );

                    SongView songView =
                            new SongView(songService);

                    songView.displayAllSongs();

                    break;


                case 4:

                    PlaylistService playlistService =
                            new PlaylistServiceImpl(
                                    new PlaylistRepositoryImpl()
                            );

                    PlaylistView playlistView =
                            new PlaylistView(playlistService);

                    playlistView.displayAllPlaylists();

                    break;


                case 0:

                    System.out.println("Logging out...");

                    break;
            }

        } while (choice != 0);
    }
}
