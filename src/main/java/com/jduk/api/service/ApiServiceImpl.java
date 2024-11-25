package com.jduk.api.service;

import com.jduk.api.data.Album;
import com.jduk.api.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    ApiRepository recordManagerRepository;

    @Override
    public List<Album> getAllAlbums() {

        List<Album> albums = new ArrayList<>();
        recordManagerRepository.findAll().forEach(albums::add);
        return albums;

    }
}
