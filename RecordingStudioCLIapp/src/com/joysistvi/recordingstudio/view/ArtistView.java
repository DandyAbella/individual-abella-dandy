package com.joysistvi.recordingstudio.view;
import java.util.List;
import com.joysistvi.recordingstudio.model.Artist;
import com.joysistvi.recordingstudio.service.ArtistService;

import java.util.Scanner;

public class ArtistView {

    private ArtistService service;
    private Scanner scanner;

    public ArtistView(ArtistService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void promptCreateArtist() {

        System.out.print("Artist Name: ");
        String artistName = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        service.createArtist(
                artistName,
                genre,
                country
        );
    }

    public void displayAllArtists() {

        System.out.println("\n=== ARTISTS ===");

        for (Artist artist : service.getAllActiveArtists()) {

            System.out.println(
                    artist.getArtistId()
                            + " | "
                            + artist.getArtistName()
                            + " | "
                            + artist.getGenre()
                            + " | "
                            + artist.getCountry()
            );
        }
    }
    public void promptSearchArtists() {

        System.out.print("Search Artist: ");
        String keyword = scanner.nextLine();

        List<Artist> artists =
                service.searchArtists(keyword);

        System.out.println("\n=== SEARCH RESULTS ===");

        for (Artist artist : artists) {

            System.out.println(
                    artist.getArtistId()
                            + " | "
                            + artist.getArtistName()
                            + " | "
                            + artist.getGenre()
                            + " | "
                            + artist.getCountry()
            );
        }
    }

    public void promptArchiveArtist() {

        System.out.print("Artist ID to Archive: ");
        int artistId = scanner.nextInt();
        scanner.nextLine();

        service.archiveArtist(artistId);
    }

    public void promptRestoreArtist() {

        System.out.print("Artist ID to Restore: ");
        int artistId = scanner.nextInt();
        scanner.nextLine();

        service.restoreArtist(artistId);
    }

    public void promptDeleteArtist() {

        System.out.print("Artist ID to Delete: ");
        int artistId = scanner.nextInt();
        scanner.nextLine();

        service.deleteArtist(artistId);
    }

    public void promptUpdateArtist() {

        System.out.print("Artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New Artist Name: ");
        String artistName = scanner.nextLine();

        System.out.print("New Genre: ");
        String genre = scanner.nextLine();

        System.out.print("New Country: ");
        String country = scanner.nextLine();

        service.updateArtist(
                artistId,
                artistName,
                genre,
                country
        );
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n=== ARTIST MENU ===");
            System.out.println("1. View Artists");
            System.out.println("2. Add Artist");
            System.out.println("3. Search Artist");
            System.out.println("4. Update Artist");
            System.out.println("5. Archive Artist");
            System.out.println("6. Restore Artist");
            System.out.println("7. Delete Artist");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    displayAllArtists();
                    break;

                case 2:
                    promptCreateArtist();
                    break;

                case 3:
                    promptSearchArtists();
                    break;

                case 4:
                    promptUpdateArtist();
                    break;

                case 5:
                    promptArchiveArtist();
                    break;

                case 6:
                    promptRestoreArtist();
                    break;

                case 7:
                    promptDeleteArtist();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


}