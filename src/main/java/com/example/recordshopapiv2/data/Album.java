package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "record")
@Builder
public class Album {

    @Id
    @GeneratedValue
    @Column(name ="album_id", updatable = false, nullable = false)
    Long albumId;

    @Column(name = "album_name", nullable = false)
    String albumName;

    // relationship one
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    Artist artist;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    Genre genre;

    @Column(name = "release_date")
    @DateTimeFormat
    LocalDate releaseDate;

    @Column(name = "age_restriction")
    boolean ageRestricted;

    // relationship two
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "album")
    @Column(name = "listings_in_stock")
    Set<Stock> listingsInStock = new HashSet<>();
}
