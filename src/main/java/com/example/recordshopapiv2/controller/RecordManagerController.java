package com.example.recordshopapiv2.controller;

import com.example.recordshopapiv2.data.Album;
import com.example.recordshopapiv2.service.RecordManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/records/")
public class RecordManagerController {

    @Autowired
    RecordManagerService recordManagerService;

    @GetMapping("all-albums")
    public ResponseEntity<List<Album>> getAllAlbums() {

        return new ResponseEntity<>(recordManagerService.getAllAlbums(), HttpStatus.OK);
    }


}
