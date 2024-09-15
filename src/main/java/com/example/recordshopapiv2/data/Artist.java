package com.example.recordshopapiv2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artist")
@Builder
public class Artist {

    @Id
    @GeneratedValue
    @Column(name = "artist_id", updatable = false, nullable = false)
    Long artistId;

    @Column(name = "artist_name")
    String artistName;

    // relationship one
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "artist")
    @Column(name = "album_id")
    Set<Album> albums = new HashSet<>();

    // relationship four
    @JsonIgnore
    @ManyToMany(mappedBy = "signedBy")
    Set<Stock> signedCopies = new HashSet<>();
}
