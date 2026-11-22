package com.joysistvi.recordingstudio.view;

import com.joysistvi.recordingstudio.model.Song;
import com.joysistvi.recordingstudio.service.SongService;

import java.util.Scanner;

public class SongView {

    private SongService service;
    private Scanner scanner;

    public SongView(SongService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n=== SONG MANAGEMENT ===");
            System.out.println("1. View Songs");
            System.out.println("2. Add Song");
            System.out.println("3. Search Song");
            System.out.println("4. Delete Song");
            System.out.println("0. Back");

            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    displayAllSongs();
                    break;

                case 2:
                    promptCreateSong();
                    break;

                case 3:
                    promptSearchSong();
                    break;

                case 4:
                    promptDeleteSong();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public void displayAllSongs() {

        System.out.println("\n=== SONGS ===");
        System.out.printf("%-5s | %-25s | %-12s | %-10s | %-10s%n",
                "ID",
                "TITLE",
                "ARTIST ID",
                "ALBUM ID",
                "DURATION"
        );


        for (Song song : service.getAllSongs()) {

            System.out.printf("%-5d | %-25s | %-12d | %-10d | %-10s%n",                    song.getSongId(),
                    song.getSongTitle(),
                    song.getArtistId(),
                    song.getAlbumId(),
                    song.getDuration()
            );
        }
    }

    public void promptCreateSong() {

        System.out.print("Song Title: ");
        String title = scanner.nextLine();

        System.out.print("Artist ID: ");
        int artistId =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Album ID: ");
        int albumId =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Duration (ex. 4:30): ");
        String duration = scanner.nextLine();

        service.createSong(
                title,
                artistId,
                albumId,
                duration
        );
    }

    public void promptDeleteSong() {

        System.out.print("Song ID: ");
        int songId =
                Integer.parseInt(scanner.nextLine());

        service.deleteSong(songId);
    }

    public void promptSearchSong() {

        System.out.print("Search Song: ");
        String keyword = scanner.nextLine();

        for (Song song : service.searchSongs(keyword)) {

            System.out.println(
                    song.getSongId()
                            + " | "
                            + song.getSongTitle()
            );
        }
    }
}