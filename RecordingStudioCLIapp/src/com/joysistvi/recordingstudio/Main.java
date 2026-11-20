package com.joysistvi.recordingstudio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DBConnection.getConnection();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n*** User ***");
        System.out.println("[1] Register");
        System.out.println("[2] Login");
        System.out.println("[0] Exit");
        System.out.print("\nEnter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        switch (choice) {

            case 1:

                System.out.print("\nEnter full name: ");
                String full_name = sc.nextLine();

                System.out.print("Enter user name: ");
                String user_name = sc.nextLine();

                System.out.print("Enter user password: ");
                String user_password = sc.nextLine();

                boolean success = RegisterUser.registerUser(
                        full_name,
                        user_name,
                        user_password
                );

                if (success) {
                    System.out.println("Registration Successful");
                } else {
                    System.out.println("Registration Failed");
                }
                break;

            case 2:

                System.out.print("User Name: ");
                String username = sc.nextLine().trim();

                System.out.print("Password: ");
                String password = sc.nextLine().trim();

                // Debug (remove later if you want)
                System.out.println("Username = [" + username + "]");
                System.out.println("Password = [" + password + "]");

                boolean correct = LoginUser.login(username, password);

                if (correct) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Invalid user name or password");
                }
                break;

            case 120:

                System.out.println("\n=== ADMIN MENU ===");
                System.out.println("[1] Add Artist");
                System.out.println("[2] View Artists");
                System.out.println("[3] Delete Artist");

                System.out.println("[4] Add Album");
                System.out.println("[5] View Albums");
                System.out.println("[6] Delete Album");

                System.out.println("[7] Add Song");
                System.out.println("[8] View Songs");
                System.out.println("[9] Delete Song");

                System.out.println("[10] Create Playlist");
                System.out.println("[11] Add Song To Playlist");
                System.out.println("[12] View Playlist");
                System.out.println("[13] Delete Playlist");

                int adminChoice = sc.nextInt();
                sc.nextLine();

                switch (adminChoice) {

                    case 1: {

                        System.out.print("Artist Name: ");
                        String artistName = sc.nextLine();

                        System.out.print("Genre: ");
                        String genre = sc.nextLine();

                        System.out.print("Country: ");
                        String country = sc.nextLine();

                        boolean added =
                                AddArtist.addArtist(
                                        artistName,
                                        genre,
                                        country);

                        if (added) {
                            System.out.println("Artist Added!");
                        } else {
                            System.out.println("Failed!");
                        }

                        break;
                    }

                    case 2: {
                        ViewArtist.viewArtists();
                        break;
                    }

                    case 3: {

                        System.out.print("Enter Artist ID to delete: ");
                        int artistId = sc.nextInt();
                        sc.nextLine();

                        boolean deleted =
                                DeleteArtist.deleteArtist(artistId);

                        if (deleted) {
                            System.out.println("Artist Deleted Successfully!");
                        } else {
                            System.out.println("Artist Not Found!");
                        }

                        break;
                    }

                    case 4: {

                        System.out.print("Album Title: ");
                        String albumTitle = sc.nextLine();

                        System.out.print("Release Year: ");
                        int releaseYear = Integer.parseInt(sc.nextLine());

                        System.out.print("Artist ID: ");
                        int artistId = Integer.parseInt(sc.nextLine());

                        boolean albumAdded =
                                AddAlbum.addAlbum(
                                        albumTitle,
                                        releaseYear,
                                        artistId);

                        if (albumAdded) {
                            System.out.println("Album Added!");
                        } else {
                            System.out.println("Failed!");
                        }

                        break;
                    }

                    case 5: {

                        ViewAlbum.viewAlbums();

                        break;
                    }

                    case 6: {

                        System.out.print("Enter Album ID: ");
                        int albumId = Integer.parseInt(sc.nextLine());

                        boolean deleted =
                                DeleteAlbum.deleteAlbum(albumId);

                        if (deleted) {
                            System.out.println("Album Deleted!");
                        } else {
                            System.out.println("Album Not Found!");
                        }

                        break;
                    }

                    case 7: {

                        System.out.print("Song Title: ");
                        String songTitle = sc.nextLine();

                        System.out.print("Duration: ");
                        String duration = sc.nextLine();

                        System.out.print("Album ID: ");
                        int albumId = Integer.parseInt(sc.nextLine());

                        boolean added =
                                AddSong.addSong(
                                        songTitle,
                                        duration,
                                        albumId
                                );

                        if (added) {
                            System.out.println("Song Added!");
                        } else {
                            System.out.println("Failed!");
                        }

                        break;
                    }

                    case 8: {

                        ViewSong.viewSongs();

                        break;
                    }

                    case 9: {

                        System.out.print("Enter Song ID: ");
                        int songId = Integer.parseInt(sc.nextLine());

                        boolean deletedSong =
                                DeleteSong.deleteSong(songId);

                        if (deletedSong) {
                            System.out.println("Song Deleted!");
                        } else {
                            System.out.println("Song Not Found!");
                        }

                        break;
                    }

                    case 10: {

                        System.out.print("Playlist Name: ");
                        String playlistName = sc.nextLine();

                        boolean created =
                                CreatePlaylist.createPlaylist(
                                        playlistName);

                        if (created) {
                            System.out.println("Playlist Created!");
                        } else {
                            System.out.println("Failed!");
                        }

                        break;
                    }

                    case 11: {

                        System.out.print("Playlist ID: ");
                        int playlistId =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Song ID: ");
                        int songId =
                                Integer.parseInt(sc.nextLine());

                        boolean addedSong =
                                AddSongToPlaylist.addSongToPlaylist(
                                        playlistId,
                                        songId);

                        if (addedSong) {
                            System.out.println("Song Added!");
                        } else {
                            System.out.println("Failed!");
                        }

                        break;
                    }

                    case 12: {

                        ViewPlaylist.viewPlaylistSongs();

                        break;
                    }

                    case 13: {

                        System.out.print("Playlist ID: ");
                        int deleteId =
                                Integer.parseInt(sc.nextLine());

                        boolean deleted =
                                DeletePlaylist.deletePlaylist(deleteId);

                        if (deleted) {
                            System.out.println("Playlist Deleted!");
                        } else {
                            System.out.println("Playlist Not Found!");
                        }

                        break;
                    }

                }

                break;

            case 0:

                System.out.println("Thank you...");
                break;

            default:

                System.out.println("Invalid Choice");
                break;
        }

        sc.close();
    }
}