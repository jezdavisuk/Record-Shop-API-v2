package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Artist;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ArtistManagerRepositoryTest {

    @Autowired
    ArtistManagerRepository artistManagerRepository;

    @Test
    @DisplayName("Creation and retrieval of instances of class Artist from H2 in-memory database.")
    public void testGetAllArtists() {

        // Arrange
        Artist artist1 = new Artist(1L, "Metallica", null, null);
        Artist artist2 = new Artist(2L, "Simple Minds", null, null);
        Artist artist3 = new Artist(3L, "Cat Stevens", null, null);

        List<Artist> expectedArtistList = new ArrayList<>();
        expectedArtistList.add(artist1);
        expectedArtistList.add(artist2);
        expectedArtistList.add(artist3);

        // Act
        artistManagerRepository.saveAll(expectedArtistList);
        Iterable<Artist> actualArtistList = artistManagerRepository.findAll();

        // Assert
        assertThat(actualArtistList).hasSize(3);
        assertThat(expectedArtistList).isEqualTo(actualArtistList);

    }

}