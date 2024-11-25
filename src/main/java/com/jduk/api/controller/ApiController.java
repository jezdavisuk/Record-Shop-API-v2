package com.jduk.api.controller;

import com.jduk.api.data.Album;
import com.jduk.api.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/records/")
@Tag(name = "TrackDaw IMS API", description = "Music On The Fly")
public class ApiController {

    @Autowired
    ApiService apiService;

    // GET all albums
    @Operation(summary = "Retrieve unfiltered list of albums on record.")
    @GetMapping("all-albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(apiService.getAllAlbums(), HttpStatus.OK);
    }

    // GET album by id
    @Operation(summary = "Retrieve album information from database record by associated ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumByID(@PathVariable @Parameter(name = "ID", description = "Unique ID associated with a particular album of choice.") Long id){
        return new ResponseEntity<>(apiService.getAlbumByID(id), HttpStatus.OK);
    }

    // DELETE album by id
    @Operation(summary = "Delete record of album from database by associated ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Album> deleteAlbumByID(@PathVariable @Parameter(name = "ID", description = "Unique ID associated with a particular album of choice.") Long id){
        return new ResponseEntity<>(apiService.deleteAlbumByID(id), HttpStatus.OK);
    }




}
