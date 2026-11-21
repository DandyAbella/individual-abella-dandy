package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Artist;
import java.util.List;

public interface ArtistService {

    List<Artist> getAllActiveArtists();

    List<Artist> getAllArchivedArtists();

    void createArtist(String artistName,
                      String genre,
                      String country);

    void updateArtist(int artistId,
                      String artistName,
                      String genre,
                      String country);

    void deleteArtist(int artistId);

    void archiveArtist(int artistId);

    void restoreArtist(int artistId);

    List<Artist> searchArtists(String keyword);
}