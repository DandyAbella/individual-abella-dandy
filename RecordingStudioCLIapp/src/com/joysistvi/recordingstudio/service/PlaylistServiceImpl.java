package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Playlist;
import com.joysistvi.recordingstudio.repository.PlaylistRepository;

import java.util.List;

public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;

    public PlaylistServiceImpl(
            PlaylistRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return repository.findAll();
    }

    @Override
    public void createPlaylist(
            String playlistName
    ) {

        Playlist playlist = new Playlist();

        playlist.setPlaylistName(
                playlistName
        );

        repository.save(playlist);
    }

    @Override
    public void deletePlaylist(
            int playlistId
    ) {
        repository.deleteById(playlistId);
    }
}