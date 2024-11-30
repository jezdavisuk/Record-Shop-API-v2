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

    @Column(name = "NAME", nullable = false, unique = true)
    private String albumName;

    @Column(name = "GENRE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "RELEASE_DATE", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    @Column(name = "IS_AGE_RESTRICTED", nullable = false)
    private boolean ageRestricted;

    @ManyToOne
    private Artist artist;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALBUM_ID")
    private Set<Stock> stock;

}
