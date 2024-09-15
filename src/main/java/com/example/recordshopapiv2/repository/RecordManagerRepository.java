package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordManagerRepository extends CrudRepository<Album, Long> {
}
