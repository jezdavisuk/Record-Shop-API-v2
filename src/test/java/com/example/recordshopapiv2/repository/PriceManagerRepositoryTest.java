package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PriceManagerRepositoryTest {

    @Autowired
    PriceManagerRepository priceManagerRepository;

    @Test
    @DisplayName("Creation and retrieval of instances of class Price from H2 in-memory database.")
    public void testGetAllPrices() {

        // Arrange
        Price price1 = new Price(1L, new BigDecimal("6.99"), new BigDecimal("11.99"), null);
        Price price2 = new Price(2L, new BigDecimal("8.99"), new BigDecimal("26.49"), null);
        Price price3 = new Price(3L, new BigDecimal("0.72"), new BigDecimal("15.99"), null);

        List<Price> expectedPriceList = new ArrayList<>();
        expectedPriceList.add(price1);
        expectedPriceList.add(price2);
        expectedPriceList.add(price3);

        // Act
        priceManagerRepository.saveAll(expectedPriceList);
        Iterable<Price> actualPriceList = priceManagerRepository.findAll();

        // Assert
        assertThat(actualPriceList).hasSize(3);
        assertThat(expectedPriceList).isEqualTo(actualPriceList);

    }
}