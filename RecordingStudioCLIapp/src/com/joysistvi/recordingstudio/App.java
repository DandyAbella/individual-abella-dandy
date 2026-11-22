package com.joysistvi.recordingstudio;

import com.joysistvi.recordingstudio.repository.UserRepository;
import com.joysistvi.recordingstudio.repository.UserRepositoryImpl;
import com.joysistvi.recordingstudio.service.UserService;
import com.joysistvi.recordingstudio.service.UserServiceImpl;
import com.joysistvi.recordingstudio.view.UserView;
import com.joysistvi.recordingstudio.model.User;
import com.joysistvi.recordingstudio.repository.ArtistRepositoryImpl;
import com.joysistvi.recordingstudio.repository.AlbumRepositoryImpl;
import com.joysistvi.recordingstudio.repository.SongRepositoryImpl;
import com.joysistvi.recordingstudio.repository.PlaylistRepositoryImpl;

import com.joysistvi.recordingstudio.service.ArtistService;
import com.joysistvi.recordingstudio.service.ArtistServiceImpl;

import com.joysistvi.recordingstudio.service.AlbumService;
import com.joysistvi.recordingstudio.service.AlbumServiceImpl;

import com.joysistvi.recordingstudio.service.SongService;
import com.joysistvi.recordingstudio.service.SongServiceImpl;

import com.joysistvi.recordingstudio.service.PlaylistService;
import com.joysistvi.recordingstudio.service.PlaylistServiceImpl;

import com.joysistvi.recordingstudio.view.ArtistView;
import com.joysistvi.recordingstudio.view.AlbumView;
import com.joysistvi.recordingstudio.view.SongView;
import com.joysistvi.recordingstudio.view.PlaylistView;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n*** User ***");
        System.out.println("[1] Register");
        System.out.println("[2] Login");
        System.out.println("[0] Exit");
        System.out.print("\nEnter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        switch (choice) {

            case 1:

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

                System.out.println("=== LOGIN ===");

                System.out.print("Username: ");
                String userName = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                boolean success =
                        userService.login(userName, password);

                if (success) {

                    User user =
                            userService.findUserByUserName(userName);

                    System.out.println("Login successful!");

                    if ("ADMIN".equalsIgnoreCase(user.getRole())) {

                        System.out.println(
                                "Welcome Administrator"
                        );

                        UserView userView =
                                new UserView(userService);

                        userView.showMenu();

                    } else {

                        System.out.println(
                                "Welcome User"
                        );

                        showUserMenu();
                    }

                } else {

                    System.out.println(
                            "Invalid username or password!"
                    );
                }

                break;

            case 0:
                System.out.println("good bye");
                break;

            default:
                System.out.println("thankyou");
                break;


        }

    }

    private static void showUserMenu() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=== USER MENU ===");
            System.out.println("1. View Artists");
            System.out.println("2. View Albums");
            System.out.println("3. View Songs");
            System.out.println("4. View Playlists");
            System.out.println("0. Logout");

            System.out.print("Choice: ");

            choice = Integer.parseInt(sc.nextLine());

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

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}