package com.jduk.api.data;

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

    @Id // primary key
    @GeneratedValue
    @Column(name = "artist_id", updatable = false, nullable = false)
    Long artistId;

    @Column(name = "artist_name")
    String artistName;

    @JsonIgnore
    @OneToMany(mappedBy = "artist")
    Set<Album> albums = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "signedBy")
    Set<Stock> signedCopies = new HashSet<>();


}
