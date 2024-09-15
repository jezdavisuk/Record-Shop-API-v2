package com.example.recordshopapiv2.service;

import com.example.recordshopapiv2.repository.ArtistManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistManagerServiceImpl implements ArtistManagerService {

    @Autowired
    ArtistManagerRepository artistManagerRepository;
}
