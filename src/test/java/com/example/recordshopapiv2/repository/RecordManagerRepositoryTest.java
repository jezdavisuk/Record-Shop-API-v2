package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.Album;
import com.example.recordshopapiv2.data.Artist;
import com.example.recordshopapiv2.data.Genre;
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
    RecordManagerRepository recordManagerRepository;

    @Test
    @DisplayName("Creation and retrieval of instances of class Album to H2 in-memory database.")
    public void testGetAllAlbums() {

        // Arrange
        Artist artist1 = new Artist(1L, "Foals", null, null);
        Artist artist2 = new Artist(2L, "Disclosure", null, null);
        Artist artist3 = new Artist(3L, "Curtis Mayfield", null, null);

        List<Album> expectedList = new ArrayList<>();
        expectedList.add(new Album(1L, "Total Life Forever", artist1, Genre.INDIE,
                LocalDate.of(2010, Month.MAY, 10), false, null));
        expectedList.add(new Album(2L, "Settle", artist2, Genre.HOUSE,
                LocalDate.of(2013, Month.JUNE, 3), false, null));
        expectedList.add(new Album(3L, "Curtis", artist3, Genre.SOUL,
                LocalDate.of(1970, Month.SEPTEMBER, 14), false, null));

        // Act
        recordManagerRepository.saveAll(expectedList);
        Iterable<Album> albums = recordManagerRepository.findAll();

        // Assert

    }
}
