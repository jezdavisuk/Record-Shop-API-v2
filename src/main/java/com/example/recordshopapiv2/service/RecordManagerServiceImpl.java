package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.data.Album;
import com.example.recordshopapiv2.repository.RecordManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordManagerServiceImpl implements RecordManagerService {

    @Autowired
    RecordManagerRepository recordManagerRepository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        recordManagerRepository.findAll().forEach(albums::add);
        return albums;
    }
}
