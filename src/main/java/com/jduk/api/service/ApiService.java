package com.jduk.api.service;

import com.jduk.api.data.Album;

import java.util.List;

public interface ApiService {
    List<Album> getAllAlbums();
    Album getAlbumbyID(Long id);
    String deleteAlbumByID(Long id);
    Album addAlbum(Album album);
    Album updateAlbumByID(Long id, Album album);
}
