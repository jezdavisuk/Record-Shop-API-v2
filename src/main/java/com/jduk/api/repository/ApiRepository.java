package com.jduk.api.repository;

import com.jduk.api.data.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends CrudRepository<Album, Long> {
}
