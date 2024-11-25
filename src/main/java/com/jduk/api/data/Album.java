package com.jduk.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    Genre genre;

    @Column(name = "release_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate releaseDate;

    @Column(name = "age_restricted")
    boolean ageRestricted;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    Artist artist;

    @JsonIgnore
    @OneToMany(mappedBy = "stockId")
    Set<Stock> stock = new HashSet<>();

}
