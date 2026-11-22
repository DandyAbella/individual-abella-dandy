package com.joysistvi.recordingstudio.view;

import com.joysistvi.recordingstudio.service.PlaylistService;
import com.joysistvi.recordingstudio.repository.PlaylistSongRepository;
import com.joysistvi.recordingstudio.repository.PlaylistSongRepositoryImpl;

import java.util.Scanner;

public class PlaylistView {

    private PlaylistService service;
    private Scanner scanner;

    public PlaylistView(PlaylistService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n=== PLAYLIST MANAGEMENT ===");
            System.out.println("1. View Playlists");
            System.out.println("2. Create Playlist");
            System.out.println("3. Add Song To Playlist");
            System.out.println("4. Remove Song From Playlist");
            System.out.println("5. Delete Playlist");
            System.out.println("0. Back");

            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    displayAllPlaylists();
                    break;

                case 2:
                    promptCreatePlaylist();
                    break;

                case 3:
                    promptAddSongToPlaylist();
                    break;

                case 4:
                    promptRemoveSongFromPlaylist();
                    break;

                case 5:
                    promptDeletePlaylist();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public void displayAllPlaylists() {

        System.out.println("\n=== PLAYLISTS ===");

        service.getAllPlaylists().forEach(playlist ->
                System.out.println(
                        playlist.getPlaylistId()
                                + " | "
                                + playlist.getPlaylistName()
                )
        );
    }

    public void promptCreatePlaylist() {

        System.out.print("Playlist Name: ");
        String playlistName = scanner.nextLine();

        service.createPlaylist(playlistName);
    }

    public void promptDeletePlaylist() {

        System.out.print("Playlist ID: ");
        int playlistId =
                Integer.parseInt(scanner.nextLine());

        service.deletePlaylist(playlistId);
    }

    public void promptAddSongToPlaylist() {

        System.out.print("Playlist ID: ");
        int playlistId =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Song ID: ");
        int songId =
                Integer.parseInt(scanner.nextLine());

        PlaylistSongRepository repository =
                new PlaylistSongRepositoryImpl();

        repository.addSongToPlaylist(
                playlistId,
                songId
        );
    }

    public void promptRemoveSongFromPlaylist() {

        System.out.print("Playlist ID: ");
        int playlistId =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Song ID: ");
        int songId =
                Integer.parseInt(scanner.nextLine());

        PlaylistSongRepository repository =
                new PlaylistSongRepositoryImpl();

        repository.removeSongFromPlaylist(
                playlistId,
                songId
        );
    }
}