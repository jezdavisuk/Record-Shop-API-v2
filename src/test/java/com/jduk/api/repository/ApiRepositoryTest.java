package com.jduk.api.repository;

import com.example.recordshopapiv2.data.*;
import com.jduk.api.data.Album;
import com.jduk.api.data.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RecordManagerRepositoryTest {

    @Autowired
    ApiRepository recordManagerRepository;

    @Test
    @DisplayName("Writes to, and reads from, H2 in-memory database three unconstrained instances of class Album.")
    public void testGetAllAlbums() {

        // Arrange
        List<Album> expectedAlbumList = getAlbumList();

        // Act
        recordManagerRepository.saveAll(expectedAlbumList);
        Iterable<Album> actualAlbumList = recordManagerRepository.findAll();

        // Assert
        assertThat(actualAlbumList).hasSize(3);
        assertThat(expectedAlbumList).isEqualTo(actualAlbumList);

    }

    private static List<Album> getAlbumList() {
        Album album1 = new Album(1L, "Total Life Forever", Genre.INDIE,
                LocalDate.of(2010, Month.MAY, 10), false, null, null);
        Album album2 = new Album(2L, "Seal", Genre.RHYTHM_AND_BLUES,
                LocalDate.of(1994, Month.MAY, 23), false, null, null);
        Album album3 = new Album(3L, "The Blueprint", Genre.RAP,
                LocalDate.of(2001, Month.SEPTEMBER, 11), true, null, null);

        List<Album> expectedAlbumList = new ArrayList<>();
        expectedAlbumList.add(album1);
        expectedAlbumList.add(album2);
        expectedAlbumList.add(album3);
        return expectedAlbumList;
    }

//    @Autowired
//    ArtistManagerRepository artistManagerRepository;
//
//    @Test
//    @DisplayName("Creation and retrieval of instances of class Artist from H2 in-memory database.")
//    public void testGetAllArtists() {
//
//        // Arrange
//        Artist artist1 = new Artist(1L, "Metallica", null, null);
//        Artist artist2 = new Artist(2L, "Simple Minds", null, null);
//        Artist artist3 = new Artist(3L, "Cat Stevens", null, null);
//
//        List<Artist> expectedArtistList = new ArrayList<>();
//        expectedArtistList.add(artist1);
//        expectedArtistList.add(artist2);
//        expectedArtistList.add(artist3);
//
//        // Act
//        artistManagerRepository.saveAll(expectedArtistList);
//        Iterable<Artist> actualArtistList = artistManagerRepository.findAll();
//
//        // Assert
//        assertThat(actualArtistList).hasSize(3);
//        assertThat(expectedArtistList).isEqualTo(actualArtistList);
//
//    }

//    @Autowired
//    PriceManagerRepository priceManagerRepository;
//
//    @Test
//    @DisplayName("Creation and retrieval of instances of class Price from H2 in-memory database.")
//    public void testGetAllPrices() {
//
//        // Arrange
//        Price price1 = new Price(1L, new BigDecimal("6.99"), new BigDecimal("11.99"), null);
//        Price price2 = new Price(2L, new BigDecimal("8.99"), new BigDecimal("26.49"), null);
//        Price price3 = new Price(3L, new BigDecimal("0.72"), new BigDecimal("15.99"), null);
//
//        List<Price> expectedPriceList = new ArrayList<>();
//        expectedPriceList.add(price1);
//        expectedPriceList.add(price2);
//        expectedPriceList.add(price3);
//
//        // Act
//        priceManagerRepository.saveAll(expectedPriceList);
//        Iterable<Price> actualPriceList = priceManagerRepository.findAll();
//
//        // Assert
//        assertThat(actualPriceList).hasSize(3);
//        assertThat(expectedPriceList).isEqualTo(actualPriceList);
//
//    }

//    @Autowired
//    StockManagerRepository stockManagerRepository;
//
//    @Test
//    @DisplayName("Creation and retrieval of instances of class Stock from H2 in-memory database.")
//    public void testGetAllStock() {
//
//        // Arrange
//        Stock stock1 = new Stock(1L, Medium.COMPACT_DISC, 42, LocalDateTime.now(), null, null);
//        Stock stock2 = new Stock(2L, Medium.VINYL, 15, LocalDateTime.now(), null, null);
//        Stock stock3 = new Stock(3L, Medium.CASSETTE_TAPE, 6, LocalDateTime.now(), null, null);
//
//        List<Stock> expectedStockList = new ArrayList<>();
//        expectedStockList.add(stock1);
//        expectedStockList.add(stock2);
//        expectedStockList.add(stock3);
//
//        // Act
//        stockManagerRepository.saveAll(expectedStockList);
//        Iterable<Stock> actualStockList = stockManagerRepository.findAll();
//
//        // Assert
//        assertThat(actualStockList).hasSize(3);
//        assertThat(expectedStockList).isEqualTo(actualStockList);
//
//    }



}
