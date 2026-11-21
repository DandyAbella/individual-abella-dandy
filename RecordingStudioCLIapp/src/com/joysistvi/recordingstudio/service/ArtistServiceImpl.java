package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Artist;
import com.joysistvi.recordingstudio.repository.ArtistRepository;

import java.util.List;

public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository repository;

    public ArtistServiceImpl(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> getAllActiveArtists() {
        return repository.findAllActive();
    }

    @Override
    public List<Artist> getAllArchivedArtists() {
        return repository.findAllArchived();
    }

    @Override
    public void createArtist(String artistName,
                             String genre,
                             String country) {

        if (artistName == null ||
                artistName.trim().isEmpty()) {

            System.out.println("Validation Error");
            return;
        }

        Artist artist = new Artist();

        artist.setArtistName(artistName);
        artist.setGenre(genre);
        artist.setCountry(country);

        repository.save(artist);
    }

    @Override
    public void updateArtist(int artistId,
                             String artistName,
                             String genre,
                             String country) {

        if (artistId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        if (artistName == null ||
                artistName.trim().isEmpty()) {

            System.out.println("Validation Error");
            return;
        }

        Artist artist = new Artist();

        artist.setArtistId(artistId);
        artist.setArtistName(artistName);
        artist.setGenre(genre);
        artist.setCountry(country);

        repository.update(artist);
    }

    @Override
    public void deleteArtist(int artistId) {

        if (artistId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        repository.deleteById(artistId);
    }

    @Override
    public void archiveArtist(int artistId) {

        if (artistId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        repository.archiveById(artistId);
    }

    @Override
    public void restoreArtist(int artistId) {

        if (artistId <= 0) {
            System.out.println("Validation Error");
            return;
        }

        repository.restoreById(artistId);
    }

    @Override
    public List<Artist> searchArtists(String keyword) {

        if (keyword == null ||
                keyword.trim().isEmpty()) {

            System.out.println("Validation Error");
            return null;
        }

        return repository.searchByName(keyword);
    }
}