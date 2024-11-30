package com.jduk.api.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ARTIST")
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long artistId;

    @Column(name = "NAME")
    String artistName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "ARTIST_ALBUM",
                joinColumns = {@JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID")})
    private Set<Album> albums;


}
