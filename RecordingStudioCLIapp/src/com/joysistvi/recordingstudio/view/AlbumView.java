package com.joysistvi.recordingstudio.view;

import com.joysistvi.recordingstudio.model.Album;
import com.joysistvi.recordingstudio.service.AlbumService;

import java.util.List;
import java.util.Scanner;

public class AlbumView {

    private AlbumService service;
    private Scanner scanner;

    public AlbumView(AlbumService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void displayAllAlbums() {

        System.out.println("\n=== ALBUMS ===");

        for (Album album : service.getAllActiveAlbums()) {

            System.out.println(
                    album.getAlbumId()
                            + " | "
                            + album.getAlbumName()
                            + " | "
                            + album.getYear()
                            + " | "
                            + album.getArtistName()
            );
        }
    }

    public void promptCreateAlbum() {

        System.out.print("Album Title: ");
        String albumName = scanner.nextLine();

        System.out.print("Release Year: ");
        int year = scanner.nextInt();

        System.out.print("Artist ID: ");
        int artistId = scanner.nextInt();

        scanner.nextLine();

        service.createAlbum(
                albumName,
                year,
                artistId
        );
    }

    public void promptSearchAlbums() {

        System.out.print("Search Album: ");
        String keyword = scanner.nextLine();

        List<Album> albums =
                service.searchAlbums(keyword);

        for (Album album : albums) {

            System.out.println(
                    album.getAlbumId()
                            + " | "
                            + album.getAlbumName()
                            + " | "
                            + album.getArtistName()
            );
        }
    }

    public void promptUpdateAlbum() {

        System.out.print("Album ID: ");
        int albumId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Album Title: ");
        String albumName = scanner.nextLine();

        System.out.print("Release Year: ");
        int year = scanner.nextInt();

        System.out.print("Artist ID: ");
        int artistId = scanner.nextInt();

        scanner.nextLine();

        service.updateAlbum(
                albumId,
                albumName,
                year,
                artistId
        );
    }

    public void promptDeleteAlbum() {

        System.out.print("Album ID to Delete: ");
        int albumId = scanner.nextInt();

        scanner.nextLine();

        service.deleteAlbum(albumId);
    }

    public void promptArchiveAlbum() {

        System.out.print("Album ID to Archive: ");
        int albumId = scanner.nextInt();

        scanner.nextLine();

        service.archiveAlbum(albumId);
    }

    public void promptRestoreAlbum() {

        System.out.print("Album ID to Restore: ");
        int albumId = scanner.nextInt();

        scanner.nextLine();

        service.restoreAlbum(albumId);
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n=== ALBUM MENU ===");
            System.out.println("1. View Albums");
            System.out.println("2. Add Album");
            System.out.println("3. Search Album");
            System.out.println("4. Update Album");
            System.out.println("5. Archive Album");
            System.out.println("6. Restore Album");
            System.out.println("7. Delete Album");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    displayAllAlbums();
                    break;

                case 2:
                    promptCreateAlbum();
                    break;

                case 3:
                    promptSearchAlbums();
                    break;

                case 4:
                    promptUpdateAlbum();
                    break;

                case 5:
                    promptArchiveAlbum();
                    break;

                case 6:
                    promptRestoreAlbum();
                    break;

                case 7:
                    promptDeleteAlbum();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}