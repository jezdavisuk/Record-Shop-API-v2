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

    Long artistId;

    String artistName;

    Set<Album> albums = new HashSet<>();

    Set<Stock> signedCopies = new HashSet<>();
}
