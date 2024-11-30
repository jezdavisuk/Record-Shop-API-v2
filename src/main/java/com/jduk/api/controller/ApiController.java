package com.jduk.api.controller;

import com.jduk.api.data.Album;
import com.jduk.api.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/records/")
@Tag(name = "TrackDaw IMS API", description = "Music On The Fly")
public class ApiController {

    @Autowired
    private ApiService apiService;

    // GET all albums
    @Operation(summary = "Retrieve unfiltered list of albums on record.")
    @GetMapping("all-albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(apiService.getAllAlbums(), HttpStatus.OK);
    }

    // GET album by id
    @Operation(summary = "Retrieve album information from database record by associated ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") @Parameter(name = "ID", description = "Unique ID associated with a particular album of choice.") Long id){
        return new ResponseEntity<Album>(apiService.getAlbumById(id), HttpStatus.OK);
    }

    // POST album
    @Operation(summary = "Create new record of type Album in database.")
    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Album to be saved to database.") Album album) {
        Album newAlbum = apiService.addAlbum(album);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("album", "/api/v1/records/" + newAlbum.getAlbumId().toString());
        return new ResponseEntity<>(newAlbum, httpHeaders, HttpStatus.CREATED);
    }

    // UPDATE album
    @Operation(summary = "Patch existing record on album with new and up-to-date information. Matched by ID requested.")
    @PatchMapping("/{id}")
    public ResponseEntity<Album> updateAlbumById(@PathVariable("id") @Parameter(name = "ID", description = "Unique ID associated with a particular album of choice.") Long id,
                                                 @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Updated album on record with outdated fields changed.") Album album) {
        return new ResponseEntity<Album>(apiService.updateAlbumById(id, album), HttpStatus.OK);
    }

    // DELETE album by id
    @Operation(summary = "Delete record of album from database by associated ID.")
    @RequestMapping(name="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAlbumById(@PathVariable("id") @Parameter(name = "ID", description = "Unique ID associated with a particular album of choice.") Long id){
        return new ResponseEntity<>(apiService.deleteAlbumById(id), HttpStatus.OK);
    }

}
