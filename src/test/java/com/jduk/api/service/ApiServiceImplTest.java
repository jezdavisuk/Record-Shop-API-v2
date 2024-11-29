package com.jduk.api.service;

import com.jduk.api.data.Album;
import com.jduk.api.data.Genre;
import com.jduk.api.repository.ApiRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
class ApiServiceImplTest {

    @Mock
    private ApiRepository mockApiRepository;

    @InjectMocks
    private ApiServiceImpl apiServiceImpl;

    @Test
    @DisplayName("Calls to apiRepository to return three persisting unconstrained instances of class Album.")
    void testGetAllAlbumsReturnsListOfAlbums() {

        // Arrange
        when(mockApiRepository.findAll()).thenReturn(getAlbumList());

        // Act
        List<Album> actualResult = apiServiceImpl.getAllAlbums();

        // Assert
        assertThat(actualResult).hasSize(3);
        assertThat(actualResult).isEqualTo(getAlbumList());

    }

    @Test
    @DisplayName("Calls to apiRepository to return one persisting unconstrained instance of class Album by its associated ID.")
    public void testGetAlbumById() throws Exception {

        List<Album> albumList = getAlbumList();

        when(mockApiRepository.findById(1L)).thenReturn(Optional.ofNullable(albumList.get(0)));
        when(mockApiRepository.findById(2L)).thenReturn(Optional.ofNullable(albumList.get(1)));
        when(mockApiRepository.findById(3L)).thenReturn(Optional.ofNullable(albumList.get(2)));

        assertThat(apiServiceImpl.getAlbumById(1L)).isEqualTo(albumList.get(0));
        assertThat(apiServiceImpl.getAlbumById(2L)).isEqualTo(albumList.get(1));
        assertThat(apiServiceImpl.getAlbumById(3L)).isEqualTo(albumList.get(2));
    }

    @Test
    @DisplayName("Passes to apiRepository any one of three unconstrained instances of class Album and verifies that response entities match.")
    public void testAddAlbum() throws Exception {

        List<Album> albumList = getAlbumList();

        when(mockApiRepository.save(albumList.get(0))).thenReturn(albumList.get(0));
        when(mockApiRepository.save(albumList.get(1))).thenReturn(albumList.get(1));
        when(mockApiRepository.save(albumList.get(2))).thenReturn(albumList.get(2));

        assertThat(apiServiceImpl.addAlbum(albumList.get(0))).isEqualTo(albumList.get(0));
        assertThat(apiServiceImpl.addAlbum(albumList.get(1))).isEqualTo(albumList.get(1));
        assertThat(apiServiceImpl.addAlbum(albumList.get(2))).isEqualTo(albumList.get(2));
    }

    @Test
    @DisplayName("Persists to apiRepository three unconstrained instances of class Album and calls service method updateAlbumById() on last entry. Verifies by response that associated record is updated with a separate new instance of type Album.")
    public void testUpdateAlbumByID() throws Exception {

        List<Album> albumList = getAlbumList();

        mockApiRepository.save(albumList.get(0));
        mockApiRepository.save(albumList.get(1));
        mockApiRepository.save(albumList.get(2));

        Album updatedAlbum = new Album(2L, "Curtis", Genre.SOUL, LocalDate.of(1970, Month.SEPTEMBER, 21), false, null, null);

        when(mockApiRepository.findById(2L)).thenReturn(Optional.of(albumList.get(1)));
        when(mockApiRepository.save(updatedAlbum)).thenReturn(updatedAlbum);

        assertThat(apiServiceImpl.updateAlbumById(2L, updatedAlbum)).isEqualTo(updatedAlbum);
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

}