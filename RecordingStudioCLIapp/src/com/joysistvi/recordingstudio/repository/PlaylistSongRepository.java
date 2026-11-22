package com.joysistvi.recordingstudio.repository;

public interface PlaylistSongRepository {

    void addSongToPlaylist(
            int playlistId,
            int songId
    );

    void removeSongFromPlaylist(
            int playlistId,
            int songId
    );
}