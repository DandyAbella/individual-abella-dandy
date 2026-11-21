package com.joysistvi.recordingstudio.view;

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
}