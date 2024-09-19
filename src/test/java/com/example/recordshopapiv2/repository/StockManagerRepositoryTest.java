package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Medium;
import com.example.recordshopapiv2.data.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StockManagerRepositoryTest {

    @Autowired
    StockManagerRepository stockManagerRepository;

    @Test
    @DisplayName("Creation and retrieval of instances of class Stock from H2 in-memory database.")
    public void testGetAllStock() {

        // Arrange
        Stock stock1 = new Stock(1L, Medium.COMPACT_DISC, 42, LocalDateTime.now(), null, null);
        Stock stock2 = new Stock(2L, Medium.VINYL, 15, LocalDateTime.now(), null, null);
        Stock stock3 = new Stock(3L, Medium.CASSETTE_TAPE, 6, LocalDateTime.now(), null, null);

        List<Stock> expectedStockList = new ArrayList<>();
        expectedStockList.add(stock1);
        expectedStockList.add(stock2);
        expectedStockList.add(stock3);

        // Act
        stockManagerRepository.saveAll(expectedStockList);
        Iterable<Stock> actualStockList = stockManagerRepository.findAll();

        // Assert
        assertThat(actualStockList).hasSize(3);
        assertThat(expectedStockList).isEqualTo(actualStockList);

    }

}