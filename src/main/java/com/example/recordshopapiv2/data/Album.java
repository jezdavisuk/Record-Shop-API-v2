package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Album {

    Long albumId;

    String albumName;

    Artist artist;

    Genre genre;

    LocalDateTime releaseDate;

    int ageRestriction;

    Set<Stock> listingsInStock = new HashSet<>();
}
