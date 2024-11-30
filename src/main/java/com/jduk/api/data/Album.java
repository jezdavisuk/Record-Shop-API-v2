package com.jduk.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ALBUM")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID", updatable = false, nullable = false)
    private Long albumId;

    @Column(name = "album_name", nullable = false, unique = true)
    String albumName;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    Genre genre;

    @Column(name = "release_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate releaseDate;

    @Column(name = "is_age_restricted", nullable = false)
    boolean ageRestricted;

    @ManyToOne
    private Artist artist;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALBUM_ID")
    private Set<Stock> stock;

}
