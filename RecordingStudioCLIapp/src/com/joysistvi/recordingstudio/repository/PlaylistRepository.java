package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.model.Playlist;
import java.util.List;

public interface PlaylistRepository {

    List<Playlist> findAll();

    void save(Playlist playlist);

    void deleteById(int playlistId);
}