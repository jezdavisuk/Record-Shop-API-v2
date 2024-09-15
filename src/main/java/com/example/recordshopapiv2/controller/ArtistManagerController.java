package com.example.recordshopapiv2.controller;

import com.example.recordshopapiv2.service.ArtistManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistManagerController {

    @Autowired
    ArtistManagerService artistManagerService;
}
