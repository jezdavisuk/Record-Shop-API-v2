package com.example.recordshopapiv2.controller;

import com.example.recordshopapiv2.data.Album;
import com.example.recordshopapiv2.data.Genre;
import com.example.recordshopapiv2.service.RecordManagerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class RecordManagerControllerTest {

    @Mock
    private RecordManagerServiceImpl mockRecordManagerServiceImpl;

    @InjectMocks
    private RecordManagerController recordManagerController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(recordManagerController).build();
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Mocks GET request to /all-albums endpoint, and verifies JSON response attributes match expected values on three unconstrained instances of class Album.")
    public void testGetAllAlbumsReturnsAlbums() throws Exception {

        // Arrange
        when(mockRecordManagerServiceImpl.getAllAlbums()).thenReturn(getAlbumList());

        // Act, Assert
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/records/all-albums").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumId").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumName").value("Total Life Forever"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].genre").value("INDIE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].releaseDate").value("10-05-2010"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ageRestricted").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].albumId").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].albumName").value("Seal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].genre").value("RHYTHM_AND_BLUES"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].releaseDate").value("23-05-1994"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ageRestricted").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].albumId").value(3L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].albumName").value("The Blueprint"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].genre").value("RAP"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].releaseDate").value("11-09-2001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ageRestricted").value(true));

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