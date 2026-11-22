package com.joysistvi.recordingstudio.view;

import com.joysistvi.recordingstudio.repository.SongRepositoryImpl;
import com.joysistvi.recordingstudio.service.SongService;
import com.joysistvi.recordingstudio.service.SongServiceImpl;
import com.joysistvi.recordingstudio.view.SongView;
import com.joysistvi.recordingstudio.repository.PlaylistRepositoryImpl;
import com.joysistvi.recordingstudio.service.PlaylistService;
import com.joysistvi.recordingstudio.service.PlaylistServiceImpl;
import com.joysistvi.recordingstudio.repository.AlbumRepositoryImpl;
import com.joysistvi.recordingstudio.service.AlbumService;
import com.joysistvi.recordingstudio.service.AlbumServiceImpl;
import com.joysistvi.recordingstudio.model.User;
import com.joysistvi.recordingstudio.service.UserService;
import com.joysistvi.recordingstudio.repository.ArtistRepositoryImpl;
import com.joysistvi.recordingstudio.service.ArtistService;
import com.joysistvi.recordingstudio.service.ArtistServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private UserService service;
    private Scanner scanner;

    public UserView(UserService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void displayAllUsers() {

        System.out.println("\n=== USERS ===");

        for (User user : service.getAllUsers()) {

            System.out.println(
                    user.getId()
                            + " | "
                            + user.getFullName()
                            + " | "
                            + user.getUserName()
                            + " | "
                            + user.getRole()
            );
        }
    }

    public void promptCreateUser() {

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Username: ");
        String userName = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Role (ADMIN/USER): ");
        String role = scanner.nextLine();

        service.createUser(
                fullName,
                userName,
                password,
                role
        );
    }

    public void promptFindUser() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        User user =
                service.findUserByUserName(username);

        if (user != null) {

            System.out.println(
                    user.getId()
                            + " | "
                            + user.getFullName()
                            + " | "
                            + user.getUserName()
                            + " | "
                            + user.getRole()
            );
        } else {

            System.out.println("User not found.");
        }
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n=== RECORDING STUDIO ===");
            System.out.println("1. User Management");
            System.out.println("2. Artist Management");
            System.out.println("3. Album Management");
            System.out.println("4. Song Management");
            System.out.println("5. Playlist Management");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    showUserManagementMenu();
                    break;

                case 2:

                    ArtistService artistService =
                            new ArtistServiceImpl(
                                    new ArtistRepositoryImpl()
                            );

                    ArtistView artistView =
                            new ArtistView(artistService);

                    artistView.showMenu();

                    break;

                case 3:

                    AlbumService albumService =
                            new AlbumServiceImpl(
                                    new AlbumRepositoryImpl()
                            );

                    AlbumView albumView =
                            new AlbumView(albumService);

                    albumView.showMenu();

                    break;

                case 4:

                    SongService songService =
                            new SongServiceImpl(
                                    new SongRepositoryImpl()
                            );

                    SongView songView =
                            new SongView(songService);

                    songView.showMenu();

                    break;

                case 5:

                    PlaylistService playlistService =
                            new PlaylistServiceImpl(
                                    new PlaylistRepositoryImpl()
                            );

                    PlaylistView playlistView =
                            new PlaylistView(
                                    playlistService
                            );

                    playlistView.showMenu();

                    break;

                case 0:

                    System.out.println("Good Bye!");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public void showUserManagementMenu() {

        int choice;

        do {

            System.out.println("\n=== USER MANAGEMENT ===");
            System.out.println("1. View Users");
            System.out.println("2. Add User");
            System.out.println("3. Find User");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("0. Back");

            System.out.print("Choice: ");

            choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    displayAllUsers();
                    break;

                case 2:
                    promptCreateUser();
                    break;

                case 3:
                    promptFindUser();
                    break;

                case 4:
                    promptUpdateUser();
                    break;

                case 5:
                    promptDeleteUser();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public void promptUpdateUser() {

        System.out.print("User ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Username: ");
        String userName = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Role (ADMIN/USER): ");
        String role = scanner.nextLine();

        service.updateUser(
                id,
                fullName,
                userName,
                password,
                role
        );
    }

    public void promptDeleteUser() {

        System.out.print("User ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        service.deleteUser(id);
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