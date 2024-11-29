package com.jduk.api.service;

import com.jduk.api.data.Album;

import java.util.List;

public interface ApiService {
    List<Album> getAllAlbums();
    Album getAlbumById(Long id);
    String deleteAlbumById(Long id);
    Album addAlbum(Album album);
    Album updateAlbumById(Long id, Album album);
}
