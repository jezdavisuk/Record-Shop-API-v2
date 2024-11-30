//package com.jduk.api.controller;
//
//import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
//import com.jduk.api.data.Album;
//import com.jduk.api.data.Genre;
//import com.jduk.api.service.ApiServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@AutoConfigureMockMvc
//@SpringBootTest
//class ApiControllerTest {
//
//    @Mock
//    private ApiServiceImpl mockApiServiceImpl;
//
//    @InjectMocks
//    private ApiController apiController;
//
//    @Autowired
//    private MockMvc mockMvcController;
//
//    private ObjectMapper mapper;
//
//    @BeforeEach
//    public void setup(){
//        mockMvcController = MockMvcBuilders.standaloneSetup(apiController).build();
//        mapper = new ObjectMapper();
//        mapper.findAndRegisterModules();
//    }
//
//    @Test
//    @DisplayName("Mocks GET request to /all-albums endpoint, and verifies JSON response attributes match expected values on three unconstrained instances of class Album.")
//    public void testGetAllAlbumsReturnsAlbums() throws Exception {
//
//        // Arrange
//        when(mockApiServiceImpl.getAllAlbums()).thenReturn(getAlbumList());
//
//        // Act, Assert
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/api/v1/records/all-albums").accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumId").value(1L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumName").value("Total Life Forever"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].genre").value("INDIE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].releaseDate").value("10-05-2010"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ageRestricted").value(false))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].albumId").value(2L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].albumName").value("Seal"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].genre").value("RHYTHM_AND_BLUES"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].releaseDate").value("23-05-1994"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ageRestricted").value(false))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[2].albumId").value(3L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[2].albumName").value("The Blueprint"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[2].genre").value("RAP"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[2].releaseDate").value("11-09-2001"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ageRestricted").value(true));
//
//    }
//
//    @Test
//    @DisplayName("Mocks GET request with integer path variable, and verifies JSON response attributes match expected values on each of three separate requests to three unconstrained instances of class Album.")
//    void testGetAlbumById() throws Exception {
//
//        // Arrange
//        List<Album> albumList = getAlbumList();
//
//        when(mockApiServiceImpl.getAlbumById(1L)).thenReturn(albumList.get(0));
//        when(mockApiServiceImpl.getAlbumById(2L)).thenReturn(albumList.get(1));
//        when(mockApiServiceImpl.getAlbumById(3L)).thenReturn(albumList.get(2));
//
//        // Act, Assert
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/api/v1/records/1").accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumId").value(1L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Total Life Forever"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("INDIE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value("10-05-2010"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.ageRestricted").value(false));
//
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/api/v1/records/2"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumId").value(2L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Seal"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("RHYTHM_AND_BLUES"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value("23-05-1994"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.ageRestricted").value(false));
//
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/api/v1/records/3"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumId").value(3L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("The Blueprint"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("RAP"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value("11-09-2001"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.ageRestricted").value(true));
//    }

//    @Test
//    @DisplayName("Mocks three POST requests to /records endpoint and verifies that JSON response attributes match across three separate requests concerning three instances of type Album.")
//    void testAddAlbum() throws Exception {
//
//        // Arrange
//        List<Album> albumList = getAlbumList();
//
//        when(mockApiServiceImpl.addAlbum(albumList.get(0))).thenReturn(albumList.get(0));
//        when(mockApiServiceImpl.addAlbum(albumList.get(1))).thenReturn(albumList.get(1));
//        when(mockApiServiceImpl.addAlbum(albumList.get(2))).thenReturn(albumList.get(2));
//
//        // Act, Assert
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.post("/api/v1/records/")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(mapper.writeValueAsString(albumList.get(0))))
//                .andDo(print());
//
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.post("/api/v1/records/")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(mapper.writeValueAsString(albumList.get(0))))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumId").value(1L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Total Life Forever"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("INDIE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value("10-05-2010"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.ageRestricted").value(false));
//
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.post("/api/v1/records/")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(mapper.writeValueAsString(albumList.get(1))))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumId").value(2L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Seal"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("RHYTHM_AND_BLUES"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value("23-05-1994"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.ageRestricted").value(false));
//
//        this.mockMvcController.perform(
//                        MockMvcRequestBuilders.post("/api/v1/records/")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(mapper.writeValueAsString(albumList.get(2))))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumId").value(3L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("The Blueprint"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("RAP"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value("11-09-2001"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.ageRestricted").value(true));
//
//        verify(mockApiServiceImpl, times(1)).addAlbum(albumList.get(0));
//        verify(mockApiServiceImpl, times(1)).addAlbum(albumList.get(1));
//        verify(mockApiServiceImpl, times(1)).addAlbum(albumList.get(2));
//    }
//
//    private static List<Album> getAlbumList() {
//        Album album1 = new Album(1L, "Total Life Forever", Genre.INDIE,
//                LocalDate.of(2010, Month.MAY, 10), false, null, null);
//        Album album2 = new Album(2L, "Seal", Genre.RHYTHM_AND_BLUES,
//                LocalDate.of(1994, Month.MAY, 23), false, null, null);
//        Album album3 = new Album(3L, "The Blueprint", Genre.RAP,
//                LocalDate.of(2001, Month.SEPTEMBER, 11), true, null, null);
//
//        List<Album> expectedAlbumList = new ArrayList<>();
//        expectedAlbumList.add(album1);
//        expectedAlbumList.add(album2);
//        expectedAlbumList.add(album3);
//        return expectedAlbumList;
//    }
//
//
//}