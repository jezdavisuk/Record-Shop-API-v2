package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceManagerRepository extends CrudRepository<Price, Long> {

}
