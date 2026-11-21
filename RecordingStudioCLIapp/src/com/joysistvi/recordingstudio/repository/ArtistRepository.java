package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.model.Artist;
import java.util.List;

public interface ArtistRepository {

    List<Artist> findAllActive();

    List<Artist> findAllArchived();

    void save(Artist artist);

    void update(Artist artist);

    void deleteById(int artistId);

    void archiveById(int artistId);

    void restoreById(int artistId);

    List<Artist> searchByName(String keyword);
}