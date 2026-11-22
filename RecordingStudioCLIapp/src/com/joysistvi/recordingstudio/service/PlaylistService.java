package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.Playlist;
import java.util.List;

public interface PlaylistService {

    List<Playlist> getAllPlaylists();

    void createPlaylist(String playlistName);

    void deletePlaylist(int playlistId);
}