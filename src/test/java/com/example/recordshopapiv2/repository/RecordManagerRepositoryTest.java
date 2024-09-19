package com.example.recordshopapiv2.repository;

import com.example.recordshopapiv2.data.*;
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
        Album album1 = new Album(1L, "Total Life Forever", Genre.INDIE,
            LocalDate.of(2010, Month.MAY, 10), false, null, null);
        Album album2 = new Album(2L, "Total Life Forever", Genre.INDIE,
                LocalDate.of(2010, Month.MAY, 10), false, null, null);
        Album album3 = new Album(3L, "Total Life Forever", Genre.INDIE,
                LocalDate.of(2010, Month.MAY, 10), false, null, null);

        List<Album> expectedAlbumList = new ArrayList<>();
        expectedAlbumList.add(album1);
        expectedAlbumList.add(album2);
        expectedAlbumList.add(album3);

        // Act
        recordManagerRepository.saveAll(expectedAlbumList);
        Iterable<Album> actualAlbumList = recordManagerRepository.findAll();

        // Assert
        assertThat(actualAlbumList).hasSize(3);
        assertThat(expectedAlbumList).isEqualTo(actualAlbumList);

    }

}
