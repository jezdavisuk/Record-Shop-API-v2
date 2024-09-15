package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockManagerRepository extends CrudRepository<Stock, Long> {
}
