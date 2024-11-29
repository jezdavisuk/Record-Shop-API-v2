package com.jduk.api.service;

import com.jduk.api.data.Album;
import com.jduk.api.exception.NoResultFoundException;
import com.jduk.api.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    ApiRepository apiRepository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        apiRepository.findAll().forEach(albums::add);
        return albums;

    }

    @Override
    public Album getAlbumById(Long id) {
        Optional<Album> album = apiRepository.findById(id);
        if(album.isPresent()) {
            return album.get();
        } else {
            throw new NoResultFoundException(String.format("Album with id '%s' cannot be located.", id));
        }
    }

    @Override
    public String deleteAlbumById(Long id) {
        Optional<Album> album = apiRepository.findById(id);
        if(album.isPresent()) {
            apiRepository.deleteById(id);
            return String.format("Album with id '%s' has been deleted successfully.", id);
        } else {
            throw new NoResultFoundException(String.format("An event with id '%s' cannot be located.", id));
        }
    }

    @Override
    public Album addAlbum(Album album) {
        return apiRepository.save(album);
    }

    @Override
    public Album updateAlbumById(Long id, Album album) {
        Optional<Album> currentAlbum = apiRepository.findById(id);
        if(currentAlbum.isPresent()) {
            Album newAlbum = currentAlbum.get();
            newAlbum.setAlbumName(album.getAlbumName());
            newAlbum.setGenre(album.getGenre());
            newAlbum.setReleaseDate(album.getReleaseDate());
            newAlbum.setAgeRestricted(album.isAgeRestricted());
            newAlbum.setArtist(album.getArtist());
            newAlbum.setStock(album.getStock());
            return apiRepository.save(newAlbum);
        } else {
            throw new NoResultFoundException(String.format("An album with id '%s' cannot be located.", id));
        }
    }
}
