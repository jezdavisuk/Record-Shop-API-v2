package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistManagerRepository extends CrudRepository<Artist, Long> {
}
